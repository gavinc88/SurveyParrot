package com.cs160.surveyparrot;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener {

	private Button resumeButton, startButton, redeemButton;
	private boolean hasActiveSurvey; //true if the user quits while taking a survey
	
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		context = this;
		
		resumeButton = (Button) findViewById(R.id.bResumeSurvey);
		resumeButton.setOnClickListener(this);
		startButton = (Button) findViewById(R.id.bStartSurvey);
		startButton.setOnClickListener(this);
		redeemButton = (Button) findViewById(R.id.bRedeemRewards);
		redeemButton.setOnClickListener(this);
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
			Intent resumeSurvey = new Intent(context, ResumeSurvey.class);
	        startActivity(resumeSurvey);
			break;
		case R.id.bStartSurvey:
			Intent startSurvey = new Intent(context, StartSurvey.class);
	        startActivity(startSurvey);
			break;
		case R.id.bRedeemRewards:
			Intent redeemRewards = new Intent(context, RedeemRewards.class);
	        startActivity(redeemRewards);
			break;
		}		
	}

}
