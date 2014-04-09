package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

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
		
		Bundle extras = getIntent().getExtras();
		TextView welcomeUser = (TextView)findViewById(R.id.welcomeUser);
		welcomeUser.setText("Welcome, " + extras.getString("username") + "!");
		
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

}
