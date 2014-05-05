package com.cs160.surveyparrot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseSurveyActivity extends Activity implements OnClickListener, RecognitionListener, TextToSpeech.OnInitListener {
	
	private Button yes, no;
	private TextView surveyNameTextView;
	private String surveyName;
	
	private SpeechRecognizer sr;
    private TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_survey);
		
		fetchSurvey();
		
		sr = SpeechRecognizer.createSpeechRecognizer(this);
		sr.setRecognitionListener(this);
		tts = new TextToSpeech(this, this);
		
		yes = (Button) findViewById(R.id.bYes);
		yes.setOnClickListener(this);
		no = (Button) findViewById(R.id.bNo);
		no.setOnClickListener(this);
		surveyNameTextView = (TextView) findViewById(R.id.surveyName);
		surveyNameTextView.setText(surveyName);		
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bYes:
			stopSpeechProcesses();
			Intent startSurvey = new Intent(this, SurveyActivity.class);
			startSurvey.putExtra("surveyId", SurveyActivity.surveyId);
			startSurvey.putExtra("questionNumber", 1);
	        startActivity(startSurvey);
	        finish();
			break;
		case R.id.bNo:
			tts.stop();
			sr.stopListening();
			loadNewSurvey();
			break;
		}
	}
	
	private void fetchSurvey(){
		surveyName = Survey.surveys.get(SurveyActivity.surveyId).name;
	}
	
	private void loadNewSurvey(){
	    SurveyActivity.surveyId += 1;
	    if (SurveyActivity.surveyId >= Survey.surveys.size()) {
	        SurveyActivity.surveyId = 0;
            Intent home = new Intent(this, MainActivity.class);
            startActivity(home);
            finish();
	    } else {
	        fetchSurvey();
	        surveyNameTextView.setText(surveyName);     
	        read();
	    }
	}
	
	@SuppressLint("NewApi")
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
            read();
        } else {
        	System.out.println("Initilization Failed!");
        }
	}
	
	public void stopSpeechProcesses(){
		System.out.println("ChooseSurveyActivity stopSpeechProcesses()");
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        sr.stopListening();
        sr.destroy();
    }
	
//	@Override
//    public void onDestroy() {
//        // Don't forget to shutdown TTS and SpeechRecognizer!
//        //stopSpeechProcesses();
//        super.onDestroy();
//    }
	
	public void read(){
		String input = "Would you like to take a survey on " + surveyName;
		HashMap<String, String> hashTts = new HashMap<String, String>();
	    hashTts.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "read_id");
	    tts.speak(input, TextToSpeech.QUEUE_FLUSH, hashTts);
	}

	public void listen() {
		System.out.println("listening...");
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.cs160.surveyparrot");
		//intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 5000);
		intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);
		sr.startListening(intent);
		
		if(Build.VERSION.SDK_INT <= 15){
			try{
				playSound(this);
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
				read();
			}else if(error == 7){ //no word match found
				System.out.println("Sorry, I did not understand what you said. Please try again.");
		    	HashMap<String, String> hashTts = new HashMap<String, String>();
			    hashTts.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "id");
			    tts.speak("Sorry, I did not understand what you said. Please try again.", TextToSpeech.QUEUE_ADD, hashTts);
			}else if(error == 2){ //network error
				Toast.makeText(this, "network error: please check your connection", Toast.LENGTH_LONG);
			}
		}

		@Override
		public void onResults(Bundle results) {
			Log.e("SPEECH RECOGNIZER","Recognize onResults()");
			ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
	        if (data.size() > 0) {
	            for (String word : data) {
	                if (word.equals("yes")) {
	                    onClick(findViewById(R.id.bYes));
	                    return;
	                } else if (word.equals("no")) {
	                    onClick(findViewById(R.id.bNo));
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
