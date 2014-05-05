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

public class MainActivity extends Activity implements OnClickListener {

	private Button resumeButton, startButton, bRedeemRewards;
	private boolean hasActiveSurvey; //true if the user quits while taking a survey
	private String surveyName;
	private int surveyId, questionNumber;
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
//		if (id == R.id.debugVoice) {
//		    Intent i = new Intent(this, DebugVoiceActivity.class);
//		    startActivity(i);
		if (id == R.id.action_settings) {
			return true;
//		}else if(id == R.id.view_completed_surveys){
//			return true;
		}else if(id == R.id.log_out){
			//remove loggedInToken from SharedPreferences
			SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
			app.removePreferences("username");
			app.removePreferences("SurveyId");
			app.removePreferences("QuestionNumber");
			
			Intent openLoginActivity = new Intent(this, LoginActivity.class);
			//clear app state so login starts with clean slate
			openLoginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			openLoginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(openLoginActivity);
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bResumeSurvey:
			Intent resumeSurvey = new Intent(this, SurveyActivity.class);
			resumeSurvey.putExtra("surveyID", surveyId);
			resumeSurvey.putExtra("questionNumber", questionNumber);
	        startActivity(resumeSurvey);
	        finish();
			break;
		case R.id.bStartSurvey:
			Intent startSurvey = new Intent(this, ChooseSurveyActivity.class);
	        startActivity(startSurvey);
	        finish();
			break;
		case R.id.bRedeemRewards:
			Intent redeemRewards = new Intent(this, RedeemRewardsActivity.class);
	        startActivity(redeemRewards);
	        //finish();
			break;
		}
	}
	
	private void getResumableSurvey(){
		//if active survey exists (check SharedPreferences)
		SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
		if(app.getIntPreferences("SurveyId") != -1){
			hasActiveSurvey = true;
			surveyId = app.getIntPreferences("SurveyId");
			surveyName = Survey.surveys.get(app.getIntPreferences("SurveyId")).name;
			questionNumber = app.getIntPreferences("QuestionNumber");
		}else{
			hasActiveSurvey = false;
			surveyName = Survey.surveys.get(0).name;
			questionNumber = 1;
		}
	}
}
