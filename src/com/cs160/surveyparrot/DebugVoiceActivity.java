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
import android.widget.TextView;

public class DebugVoiceActivity extends Activity implements RecognitionListener {
    SpeechRecognizer recog;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_voice);
        text = (TextView) findViewById(R.id.debugVoiceText);
        recog = SpeechRecognizer.createSpeechRecognizer(this);
        recog.setRecognitionListener(this);
        Intent recintent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); 
        recintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,  RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        recintent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak!");
        recintent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.cs160.surveryparrot");
        recog.startListening(recintent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.debug_voice, menu);
        return true;
    }

    @Override
    public void onResults(Bundle results) {
        Log.e("TAG","Recognize Results");
        ArrayList<String> list = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (list.size() > 0) {
            text.setText(list.get(0));
        }
    }

    @Override
    public void onBeginningOfSpeech() {
        Log.e("TAG","Recognize Begin Speech");
    }

    @Override
    public void onBufferReceived(byte[] arg0) {
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
    public void onEvent(int arg0, Bundle arg1) {
    }

    @Override
    public void onPartialResults(Bundle partialResults) {
    }

    @Override
    public void onReadyForSpeech(Bundle params) {
        Log.e("TAG","Recognize Ready");
    }

    @Override
    public void onRmsChanged(float rmsdB) {
    }
}
