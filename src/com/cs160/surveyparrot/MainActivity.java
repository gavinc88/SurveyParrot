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

public class MainActivity extends Activity implements OnClickListener {

	private Button resumeButton, startButton, redeemButton;
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
		
		resumeButton = (Button) findViewById(R.id.bResumeSurvey);
		resumeButton.setOnClickListener(this);
		startButton = (Button) findViewById(R.id.bStartSurvey);
		startButton.setOnClickListener(this);
		redeemButton = (Button) findViewById(R.id.bRedeemRewards);
		redeemButton.setOnClickListener(this);
		
		if(!hasActiveSurvey){
			resumeButton.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bResumeSurvey:
			Intent resumeSurvey = new Intent(context, SurveyActivity.class);
			resumeSurvey.putExtra("survey", surveyName);
			resumeSurvey.putExtra("questionNumber", questionNumber);
	        startActivity(resumeSurvey);
			break;
		case R.id.bStartSurvey:
			Intent startSurvey = new Intent(context, ChooseSurveyActivity.class);
	        startActivity(startSurvey);
			break;
		case R.id.bRedeemRewards:
			Intent redeemRewards = new Intent(context, RedeemRewardsActivity.class);
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
