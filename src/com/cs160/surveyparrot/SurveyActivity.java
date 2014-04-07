package com.cs160.surveyparrot;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
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
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class SurveyActivity extends Activity implements OnClickListener, RecognitionListener {

	private Button stopButton, repeatButton, nextButton;
	private ProgressBar progressbar;
	private TextView progressMessage;
	private String surveyName;
	private int questionNumber, tempQuestionNumber;
	private ArrayList<Question> questions;
	private SoundFragment questionFragment;
    private SpeechRecognizer recog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey);

		recog = SpeechRecognizer.createSpeechRecognizer(this);
        recog.setRecognitionListener(this);
        Intent recintent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); 
        recintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,  RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        recintent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak!");
        recintent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.cs160.surveryparrot");
        recog.startListening(recintent);
		
		stopButton = (Button) findViewById(R.id.bStop);
		stopButton.setOnClickListener(this);
		repeatButton = (Button) findViewById(R.id.bRepeat);
		repeatButton.setOnClickListener(this);
		nextButton = (Button) findViewById(R.id.bNext);
		nextButton.setOnClickListener(this);
		progressMessage = (TextView) findViewById(R.id.surveyProgressText);
		progressbar = (ProgressBar) findViewById(R.id.surveyProgress);
		
		Bundle args = getIntent().getExtras();
		surveyName = args.getString("survey");
		questionNumber = args.getInt("questionNumber");
		
		getSurveyQuestions(surveyName); //make server call to get survey info

		loadQuestion(questionNumber);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bStop:
			saveSurvey();
			Intent openMainActivity = new Intent(this, MainActivity.class);
	        startActivity(openMainActivity);
			break;
		case R.id.bRepeat:
			System.out.println("repeat pressed");
			break;
		case R.id.bNext:
			if(questionNumber > questions.size()){
				Intent findNewSurvey = new Intent(this, ChooseSurveyActivity.class);
		        startActivity(findNewSurvey);
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
			saveSurvey();
			finish();
		}else{
			loadQuestion(questionNumber);
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
			final Dialog dialog = new Dialog(this);
			dialog.setContentView(R.layout.dialog_dropdown);
			dialog.setTitle("Choose Question:");
 
			// set the custom dialog components - spinner and button
			Spinner spinner = (Spinner) dialog.findViewById(R.id.questionSpinner);
			String[] array_spinner = new String[questionNumber];
			for(int i = 0; i < questionNumber; i++){
				array_spinner[i] = (i + 1) + "";
			}
	        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array_spinner);
	        spinner.setAdapter(adapter);
	        spinner.setSelection(questionNumber-1);
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
 
			Button confirmButton = (Button) dialog.findViewById(R.id.bJump);
			confirmButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					questionNumber = tempQuestionNumber;
					loadQuestion(questionNumber);
					dialog.dismiss();
				}
			});
 
			dialog.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void saveSurvey(){
		//save survey for resume
	}
	
	private void getSurveyQuestions(String surveyName){
		questions = new ArrayList<Question>(3);
		questions.add(new Question(getResources().getString(R.string.question1), Question.QUESTION_TYPE_MULTIPLE_CHOICE, 2));
		questions.add(new Question(getResources().getString(R.string.question2), Question.QUESTION_TYPE_RATING));
		questions.add(new Question(getResources().getString(R.string.question3), Question.QUESTION_TYPE_YES_NO));
		progressbar.setMax(questions.size());
	}
	
	private void loadQuestion(int questionNumber){
		progressMessage.setText("Question "+questionNumber+" of "+questions.size());
		progressbar.setProgress(questionNumber);
		if(questions.get(questionNumber-1).getType() == Question.QUESTION_TYPE_MULTIPLE_CHOICE){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionMultipleChoiceFragment();
			Bundle args = new Bundle();
			args.putInt("questionNumber", questionNumber);
			args.putString("question",questions.get(questionNumber-1).getQuestion());
			args.putInt("numChoice", questions.get(questionNumber-1).getNumChoice());
			questionFragment.setArguments(args);
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}else if(questions.get(questionNumber-1).getType() == Question.QUESTION_TYPE_RATING){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionRatingFragment();
			Bundle args = new Bundle();
			args.putInt("questionNumber", questionNumber);
			args.putString("question",questions.get(questionNumber-1).getQuestion());
			questionFragment.setArguments(args);
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}else if(questions.get(questionNumber-1).getType() == Question.QUESTION_TYPE_YES_NO){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionYesNoFragment();
			Bundle args = new Bundle();
			args.putInt("questionNumber", questionNumber);
			args.putString("question",questions.get(questionNumber-1).getQuestion());
			questionFragment.setArguments(args);
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}
	}
	
	//our audio processor from each fragment should call getActivity().getNextQuestion() to automatically proceed
	public void getNextQuestion(){
		questionNumber++;
		if(questionNumber > questions.size()){
			progressMessage.setText("Survey Completed!");
			repeatButton.setVisibility(View.INVISIBLE);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			Fragment newFragment = new SurveyCompleteFragment();
			ft.replace(R.id.questionFragment, newFragment).commit();
		}else{
			loadQuestion(questionNumber);
		}
	}

    @Override
    public void onResults(Bundle results) {
        Log.e("TAG","Recognize Results");
        ArrayList<String> list = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (list.size() > 0) {
            questionFragment.processWord(list.get(0));
        }
    }
    @Override
    public void onBeginningOfSpeech() {
        Log.e("TAG","Recognize Begin Speech");
    }
    @Override
    public void onEndOfSpeech() {
        Log.e("TAG","Recognize End Speech");
    }
    @Override
    public void onError(int arg0) {
        Log.e("TAG","Recognize Error");
    }
    @Override
    public void onReadyForSpeech(Bundle params) {
        Log.e("TAG","Recognize Ready");
    }
    @Override
    public void onBufferReceived(byte[] arg0) {
    }
    @Override
    public void onEvent(int arg0, Bundle arg1) {
    }
    @Override
    public void onPartialResults(Bundle partialResults) {
    }
    @Override
    public void onRmsChanged(float rmsdB) {
    }
}
