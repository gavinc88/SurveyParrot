package com.cs160.surveyparrot;

import java.util.Locale;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, TextToSpeech.OnInitListener {

	private Button resumeButton, startButton, bRedeemRewards;
	private boolean hasActiveSurvey; //true if the user quits while taking a survey
	private String surveyName;
	private int questionNumber;
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		
		getResumableSurvey();
		
		TextView welcomeUser = (TextView)findViewById(R.id.welcomeUser);
		welcomeUser.setText("Welcome, " + SurveyParrotApplication.username + "!");
		
		resumeButton = (Button) findViewById(R.id.bResumeSurvey);
		resumeButton.setOnClickListener(this);
		startButton = (Button) findViewById(R.id.bStartSurvey);
		startButton.setOnClickListener(this);
		bRedeemRewards = (Button) findViewById(R.id.bRedeemRewards);
		bRedeemRewards.setOnClickListener(this);
		
		if(!hasActiveSurvey){
			resumeButton.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.debugVoice) {
		    Intent i = new Intent(this, DebugVoiceActivity.class);
		    startActivity(i);
		} else if (id == R.id.action_settings) {
			//Temp for testing text to speech
			final Dialog dialog = new Dialog(this);
			dialog.setContentView(R.layout.dialog_edittext);
			dialog.setTitle("Enter text to speak:");
			
			et = (EditText) dialog.findViewById(R.id.editText);
			
			initializeTTS();
			
			Button confirmButton = (Button) dialog.findViewById(R.id.bConfirm);
			confirmButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					speak(et.getText().toString());
					//dialog.dismiss();
				}
			});
			dialog.setOnDismissListener(new OnDismissListener(){
				@Override
				public void onDismiss(DialogInterface dialog) {
					if (tts != null) {
			            tts.stop();
			            tts.shutdown();
			        }
				}				
			});
			dialog.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bResumeSurvey:
			Intent resumeSurvey = new Intent(this, SurveyActivity.class);
			resumeSurvey.putExtra("survey", surveyName);
			resumeSurvey.putExtra("questionNumber", questionNumber);
	        startActivity(resumeSurvey);
			break;
		case R.id.bStartSurvey:
			Intent startSurvey = new Intent(this, ChooseSurveyActivity.class);
	        startActivity(startSurvey);
			break;
		case R.id.bRedeemRewards:
			Intent redeemRewards = new Intent(this, RedeemRewardsActivity.class);
	        startActivity(redeemRewards);
			break;
		}
	}
	
	private void getResumableSurvey(){
		//if active survey exists (check database)
		hasActiveSurvey = true;
		surveyName = "Snacks";
		questionNumber = 3;
		//else hasActiveSurvey = false;
	}
	
	private TextToSpeech tts;
	private EditText et;
	
	public void initializeTTS(){
		tts = new TextToSpeech(this, this);
		//tts.setLanguage(Locale.US);
	}

	public void speak(String text){
		System.out.println("speaking: " + text);
		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}
	
	@Override
    public void onInit(int status) {
 
        if (status == TextToSpeech.SUCCESS) {
 
            int result = tts.setLanguage(Locale.US);
 
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                System.out.println("This Language is not supported");
            } else {
                //btnSpeak.setEnabled(true);
                //speak(et.getText().toString());
            } 
        } else {
        	System.out.println("Initilization Failed!");
        }
    }
	
	@Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
