package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ChooseSurveyActivity extends Activity implements OnClickListener {
	
	private Button yes, no;
	private TextView surveyNameTextView;
	private String surveyName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_survey);
		
		fetchSurvey();
		
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
			Intent startSurvey = new Intent(this, SurveyActivity.class);
			startSurvey.putExtra("survey", surveyName);
			startSurvey.putExtra("questionNumber", 1);
	        startActivity(startSurvey);
			break;
		case R.id.bNo:
			loadNewSurvey();
			break;
		}
	}
	
	private void fetchSurvey(){
		//set survey object to something
		surveyName = "Snacks";
	}
	
	private void loadNewSurvey(){
		//load new survey
		fetchSurvey();
	}

}
