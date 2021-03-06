package com.cs160.surveyparrot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SurveyActivity extends Activity implements OnClickListener, RecognitionListener, TextToSpeech.OnInitListener {

	private Button stopButton, repeatButton, nextButton;
	private ProgressBar progressbar;
	private TextView progressMessage;
	private String surveyName;
	private int questionNumber, tempQuestionNumber;
	private ArrayList<Question> questions;
	private SoundFragment questionFragment;
	private SpeechRecognizer sr;
    private TextToSpeech tts;
    public static int surveyId = 0;
    Context context;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		context = this;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey);
		
		stopButton = (Button) findViewById(R.id.bStop);
		stopButton.setOnClickListener(this);
		repeatButton = (Button) findViewById(R.id.bRepeat);
		repeatButton.setOnClickListener(this);
		nextButton = (Button) findViewById(R.id.bNext);
		nextButton.setOnClickListener(this);
		progressMessage = (TextView) findViewById(R.id.surveyProgressText);
		progressbar = (ProgressBar) findViewById(R.id.surveyProgress);
		
		Bundle args = getIntent().getExtras();
		surveyId = args.getInt("surveyId");
		questionNumber = args.getInt("questionNumber");
		
		getSurveyQuestions(surveyId); //make server call to get survey info
		System.out.println("questions.size(): "+questions.size());
		
		tts = new TextToSpeech(this, this);
				
		sr = SpeechRecognizer.createSpeechRecognizer(this);
		sr.setRecognitionListener(this);
		
		//show help if not disabled
		SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
		if(!app.getBooleanPreferences("help1")){
			showHelpDialog(1);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onInit(int status) {
		System.out.println("initializing tts");
		if (status == TextToSpeech.SUCCESS) {
			if (Build.VERSION.SDK_INT >= 15) {
				System.out.println("set utternace progress listener");
				tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
					@Override
					public void onDone(String utteranceId) {
						System.out.println("utterance progress onDone");
						runOnUiThread(new Runnable(){
							@Override
							public void run() {
								listen();
							}
						});
					}

					@Override
					public void onError(String utteranceId) {
						System.out.println("utterance progress onError");
					}

					@Override
					public void onStart(String utteranceId) {
						System.out.println("utterance progress onStart");
					}
				});
			} else {
				System.out.println("set utternace completed listener");
				tts.setOnUtteranceCompletedListener(new OnUtteranceCompletedListener() {
					@Override
					public void onUtteranceCompleted(String utteranceId) {
						runOnUiThread(new Runnable(){
							@Override
							public void run() {
								listen();
							}
						});
					}
				});
			}
            tts.setLanguage(Locale.US);
            tts.setPitch(1.0f);
            System.out.println("Initilization Complete!");
            loadQuestion(questionNumber);
        } else {
        	System.out.println("Initilization Failed!");
        }
	}
	
	public void stopSpeechProcesses(){
		System.out.println("SurveyActivity stopSpeechProcesses()");
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        sr.stopListening();
        sr.destroy();
    }
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bStop:
			saveSurvey();
			stopSpeechProcesses();
			Intent openMainActivity = new Intent(this, MainActivity.class);
	        startActivity(openMainActivity);
	        finish();
			break;
		case R.id.bRepeat:
			readQuestion(questionNumber);
			break;
		case R.id.bNext:
			//questionNumber++;
			if(questionNumber > questions.size()){
				stopSpeechProcesses();
				Intent findNewSurvey = new Intent(this, ChooseSurveyActivity.class);
		        startActivity(findNewSurvey);
		        finish();
			}else{
				getNextQuestion();
			}
			break;
		}		
	}
	
	@Override
	public void onBackPressed(){
		questionNumber--;
		if(questionNumber <= 0){
			//saveSurvey();
			stopSpeechProcesses();
			Intent openMainActivity = new Intent(this, MainActivity.class);
	        startActivity(openMainActivity);
			finish();
		}else{
			loadQuestion(questionNumber);
			repeatButton.setVisibility(View.VISIBLE);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.survey_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_jump){
			sr.stopListening();
			final Dialog dialog = new Dialog(this);
			dialog.setContentView(R.layout.dialog_dropdown);
			dialog.setTitle("Choose Question:");
			int count;
			if(questionNumber > questions.size()){
				count = questions.size();
			}else{
				count = questionNumber;
			}
			final int c = count;			
			// set the custom dialog components - spinner and button
			Spinner spinner = (Spinner) dialog.findViewById(R.id.questionSpinner);
			String[] array_spinner = new String[c];
			for(int i = 0; i < c; i++){
				array_spinner[i] = (i + 1) + "";
			}
	        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array_spinner);
	        spinner.setAdapter(adapter);
	        spinner.setSelection(c-1);
	        spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					tempQuestionNumber = position + 1;					
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					tempQuestionNumber = questionNumber;
				}
	        });
 
			Button confirmButton = (Button) dialog.findViewById(R.id.bConfirm);
			confirmButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					questionNumber = tempQuestionNumber;
					tts.stop();
					sr.stopListening();
					loadQuestion(questionNumber);
					repeatButton.setVisibility(View.VISIBLE);
					dialog.dismiss();
				}
			});
 			dialog.show();
			return true;
		}else if(id == R.id.action_view_commands){
			showHelpDialog(1);
		}else if(id == R.id.action_help){
			showHelpDialog(2);
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void showHelpDialog(int helpNumber) {
		//helpNumber = 1 for list of voice commands
		//helpNumber = 2 for NATO instructions
		
		final String help = "help"+helpNumber;
		
		//Show instructions for NATO phonetics
		View checkBoxView = View.inflate(this, R.layout.dialog_help, null);
		CheckBox checkBox = (CheckBox) checkBoxView.findViewById(R.id.checkbox_help);
		SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
		checkBox.setChecked(app.getBooleanPreferences(help));
		checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

		    @Override
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	    		SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
	    		app.savePreferences(help, isChecked);
		    }
		});
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setView(checkBoxView);
		alertDialogBuilder.setTitle("Help");
		
		if(helpNumber == 1){
			alertDialogBuilder.setMessage("If you ever get stuck, try the following commands:\n- Back\n- Repeat\n- Stop\n- Next");
		}else if(helpNumber == 2){
			alertDialogBuilder.setMessage("If the speech recognition program is not recognizing your answers. " +
				"Try replacing your answers to the following:\n" +
				"A -> Alpha \nB -> Bravo\nC -> Charlie\nD -> Delta\nE -> Echo");				
		}
		alertDialogBuilder.setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		AlertDialog helpDialog = alertDialogBuilder.create();
		helpDialog.show();
	}
	
	private void saveSurvey(){
		//save survey for resume
		if(questionNumber <= questions.size()){
			SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
			app.savePreferences("SurveyId", surveyId);
			app.savePreferences("QuestionNumber", questionNumber);
		}
	}
	
	private void getSurveyQuestions(int index){
		questions = Survey.surveys.get(index).getQuestions();
		progressbar.setMax(questions.size());
	}
	
	//our audio processor from each fragment should call getActivity().getNextQuestion() to automatically proceed
	public void getNextQuestion(){
		questionNumber++;
		System.out.println("questionNumber: " + questionNumber);
		if(questionNumber > questions.size()){
			progressMessage.setText("Survey Completed!");
			repeatButton.setVisibility(View.INVISIBLE);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			Fragment newFragment = new SurveyCompleteFragment();
			ft.replace(R.id.questionFragment, newFragment).commit();
			read("Thank you for completing this survey! Would you like to take another one?", false);
			
			//clear saved survey
			SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
			app.removePreferences("SurveyId");
			app.removePreferences("QuestionNumber");
		}else{
			loadQuestion(questionNumber);
		}
	}
	
	private void loadQuestion(int questionNumber){
		sr.stopListening();
		progressMessage.setText("Question "+questionNumber+" of "+questions.size());
		progressbar.setProgress(questionNumber);
		Question question = questions.get(questionNumber-1);
		if(question.getType() == Question.QUESTION_TYPE_MULTIPLE_CHOICE){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionMultipleChoiceFragment();
			Bundle args = new Bundle();
			args.putInt("questionNumber", questionNumber);
			args.putString("question",question.getQuestion());
			args.putInt("numChoice", question.getNumChoice());
			args.putString("answera", question.getAnswer(0));
            args.putString("answerb", question.getAnswer(1));
            if (question.getNumChoice() > 2)
                args.putString("answerc", question.getAnswer(2));
            if (question.getNumChoice() > 3)
                args.putString("answerd", question.getAnswer(3));
            if (question.getNumChoice() > 4)
                args.putString("answere", question.getAnswer(4));			
			questionFragment.setArguments(args);
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}else if(question.getType() == Question.QUESTION_TYPE_RATING){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionRatingFragment();
			Bundle args = new Bundle();
			args.putInt("questionNumber", questionNumber);
			args.putString("question",question.getQuestion());
			questionFragment.setArguments(args);
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}else if(question.getType() == Question.QUESTION_TYPE_YES_NO){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionYesNoFragment();
			Bundle args = new Bundle();
			args.putInt("questionNumber", questionNumber);
			args.putString("question",question.getQuestion());
			questionFragment.setArguments(args);
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}
		readQuestion(questionNumber);
	}
	
	public void readQuestion(int questionNumber){
		if(questionNumber <= questions.size()){
			Question q = questions.get(questionNumber -1);
			String qNumber = "Question number " + questionNumber + " of " + questions.size();
			String question = q.getQuestion();
			System.out.println("speaking: " + qNumber + ": " + question);
			
			HashMap<String, String> hashTts = new HashMap<String, String>();
		    hashTts.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "question_id");
			
			if(q.getType() == Question.QUESTION_TYPE_MULTIPLE_CHOICE){
				tts.speak(qNumber, TextToSpeech.QUEUE_FLUSH, null);
				tts.speak(question, TextToSpeech.QUEUE_ADD, null);
				for(int i = 0; i < q.getNumChoice(); i++){
					if(i == q.getNumChoice()-1){
						tts.speak(q.getAnswer(i), TextToSpeech.QUEUE_ADD, hashTts);
					}else{
						tts.speak(q.getAnswer(i), TextToSpeech.QUEUE_ADD, null);
					}
				}
			}else if(q.getType() == Question.QUESTION_TYPE_RATING){
				tts.speak(qNumber, TextToSpeech.QUEUE_FLUSH, null);
				tts.speak(question, TextToSpeech.QUEUE_ADD, hashTts);
			}else if(q.getType() == Question.QUESTION_TYPE_YES_NO){
				tts.speak(qNumber, TextToSpeech.QUEUE_FLUSH, null);
				tts.speak(question, TextToSpeech.QUEUE_ADD, hashTts);
			}
		}else{
			System.out.println("No questions left");
			read("Thank you for completing this survey! Would you like to take another one?", false);
		}
	}
	
	public void listen() {
		System.out.println("listening...");
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.cs160.surveyparrot");
		//intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 5000);
		intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
		sr.startListening(intent);
		
		if(Build.VERSION.SDK_INT <= 15){
			try{
				playSound(context);
			}catch(Exception e){
				Log.e("play sound", e.getMessage());
			}
		}
	}
	
	public void playSound(Context context) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {

		Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		MediaPlayer mMediaPlayer = new MediaPlayer();
		mMediaPlayer.setDataSource(context, soundUri);
		final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

		if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
			mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
			mMediaPlayer.setLooping(false);
			mMediaPlayer.prepare();
			mMediaPlayer.start();
		}
	}

//	@Override
//    public void onDestroy() {
//        // Don't forget to shutdown TTS and SpeechRecognizer!
//        stopSpeechProcesses();
//        super.onDestroy();
//    }
	
	public void read(String input, boolean end){
		System.out.println("reading: " + input);
		if(end){
			tts.speak(input, TextToSpeech.QUEUE_FLUSH, null);
		}else{
			//listen to new input
	    	HashMap<String, String> hashTts = new HashMap<String, String>();
		    hashTts.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "read_id");
		    tts.speak(input, TextToSpeech.QUEUE_FLUSH, hashTts);
		}
	}

	//---------------- Speech Recognizer Listener Start --------------------------
	@Override
	public void onReadyForSpeech(Bundle params) {
		Log.e("SPEECH RECOGNIZER","Recognize Ready");
	}

	@Override
	public void onBeginningOfSpeech() {
		Log.e("SPEECH RECOGNIZER","Recognize Begin Speech");
	}

	@Override
	public void onRmsChanged(float rmsdB) {	}

	@Override
	public void onBufferReceived(byte[] buffer) { }

	@Override
	public void onEndOfSpeech() {
		 Log.e("SPEECH RECOGNIZER","Recognize End Speech");
	}

	@Override
	public void onError(int error) {
		Log.e("SPEECH RECOGNIZER","Recognize Error: "+ error);
		if(error == 6){ //speech recognizer timed out
			readQuestion(questionNumber);
		}else if(error == 7){ //no word match found
			//show help if not disabled
			SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
    		if(!app.getBooleanPreferences("help2")){
    			showHelpDialog(2);
    		}
    		
			System.out.println("Sorry, I did not understand what you said. Please try again.");
	    	HashMap<String, String> hashTts = new HashMap<String, String>();
		    hashTts.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "id");
		    tts.speak("Sorry, I did not understand what you said. Please try again.", TextToSpeech.QUEUE_ADD, hashTts);
		}else if(error == 2){ //network error
			Toast.makeText(this, "network error: please check your connection", Toast.LENGTH_LONG);
		}else if(error == 8){ //server busy
			readQuestion(questionNumber);
		}
	}

	@Override
	public void onResults(Bundle results) {
		Log.e("SPEECH RECOGNIZER","Recognize onResults()");
		ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (data.size() > 0) {
            for (String word : data) {
                if (word.toLowerCase(Locale.US).equals("stop")) {
                    onClick(findViewById(R.id.bStop));
                    return;
                } else if (word.toLowerCase(Locale.US).equals("repeat")) {
                    onClick(findViewById(R.id.bRepeat));
                    return;
                } else if (word.toLowerCase(Locale.US).equals("next")) {
                    onClick(findViewById(R.id.bNext));
                    return;
                } else if (word.toLowerCase(Locale.US).equals("back")) {
                	onBackPressed();
                	return;
                } else if (questionNumber > questions.size() && word.toLowerCase(Locale.US).equals("yes")){
                	onClick(findViewById(R.id.bNext));
                	return;
                } else if (questionNumber > questions.size() && word.toLowerCase(Locale.US).equals("no")){
                	onClick(findViewById(R.id.bStop));
                	return;
                } else if (questionNumber <= questions.size() && questionFragment.processWord(word.toLowerCase(Locale.US))){
                	return;
                }
            }
            System.out.println("Sorry, " + data.get(0) + " is not a valid command. Please try again.");
        	HashMap<String, String> hashTts = new HashMap<String, String>();
    	    hashTts.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "id");
    	    tts.speak("Sorry, " + data.get(0) + " is not a valid command. Please try again.", TextToSpeech.QUEUE_ADD, hashTts);
    	    return;
        }
    	
	}

	@Override
	public void onPartialResults(Bundle partialResults) { }

	@Override
	public void onEvent(int eventType, Bundle params) {	}
	
	//---------------- Speech Recognizer Listener End --------------------------

}

