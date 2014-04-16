package com.cs160.surveyparrot;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DebugVoiceActivity extends Activity implements OnClickListener, RecognitionListener {

	private TextView mText;
	private SpeechRecognizer sr;
	private static final String TAG = "DebugVoiceActivity";
	private Button listen;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_debug_voice);
		listen = (Button) findViewById(R.id.bListen);
		mText = (TextView) findViewById(R.id.debugVoiceText);
		listen.setOnClickListener(this);
		sr = SpeechRecognizer.createSpeechRecognizer(this);
		sr.setRecognitionListener(this);
	}

	public void onReadyForSpeech(Bundle params) {
		Log.d(TAG, "onReadyForSpeech");
	}

	public void onBeginningOfSpeech() {
		Log.d(TAG, "onBeginningOfSpeech");
	}

	public void onRmsChanged(float rmsdB) {
		//Log.d(TAG, "onRmsChanged");
	}

	public void onBufferReceived(byte[] buffer) {
		//Log.d(TAG, "onBufferReceived");
	}

	public void onEndOfSpeech() {
		Log.d(TAG, "onEndofSpeech");
	}

	public void onError(int error) {
		Log.d(TAG, "error " + error);
		mText.setText("error " + error);
		listen.setText("Listen");
	}

	public void onResults(Bundle results) {
		String str = new String();
		Log.d(TAG, "onResults " + results);
		ArrayList data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
		for (int i = 0; i < data.size(); i++) {
			Log.d(TAG, "result " + data.get(i));
			str += data.get(i) + "\n";
		}
		mText.setText("results: \n" + str);
		listen.setText("Listen");
	}

	public void onPartialResults(Bundle partialResults) {
		Log.d(TAG, "onPartialResults");
	}

	public void onEvent(int eventType, Bundle params) {
		Log.d(TAG, "onEvent " + eventType);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.bListen){
			System.out.println("listening...");
			listen.setText("Listening...");
			Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
			intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
			intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.cs160.surveyparrot");
			intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 5000);
			intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);
			sr.startListening(intent);
			//Log.i("111111", "11111111");
		}
	}
}
// SpeechRecognizer recog;
// TextView text;
//
// @Override
// protected void onCreate(Bundle savedInstanceState) {
// super.onCreate(savedInstanceState);
// setContentView(R.layout.activity_debug_voice);
// text = (TextView) findViewById(R.id.debugVoiceText);
// recog = SpeechRecognizer.createSpeechRecognizer(this);
// recog.setRecognitionListener(this);
// Intent recintent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
// recintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
// RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// recintent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak!");
// recintent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
// "com.cs160.surveryparrot");
// recog.startListening(recintent);
// }
//
// @Override
// public boolean onCreateOptionsMenu(Menu menu) {
// getMenuInflater().inflate(R.menu.debug_voice, menu);
// return true;
// }
//
// @Override
// public void onResults(Bundle results) {
// Log.e("TAG","Recognize Results");
// ArrayList<String> list =
// results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
// if (list.size() > 0) {
// text.setText(list.get(0));
// }
// }
//
// @Override
// public void onBeginningOfSpeech() {
// Log.e("TAG","Recognize Begin Speech");
// }
//
// @Override
// public void onBufferReceived(byte[] arg0) {
// }
//
// @Override
// public void onEndOfSpeech() {
// Log.e("TAG","Recognize End Speech");
// }
//
// @Override
// public void onError(int arg0) {
// Log.e("TAG","Recognize Error");
// }
//
// @Override
// public void onEvent(int arg0, Bundle arg1) {
// }
//
// @Override
// public void onPartialResults(Bundle partialResults) {
// }
//
// @Override
// public void onReadyForSpeech(Bundle params) {
// Log.e("TAG","Recognize Ready");
// }
//
// @Override
// public void onRmsChanged(float rmsdB) {
// }
// }
