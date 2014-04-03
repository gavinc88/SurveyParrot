package com.cs160.surveyparrot;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class SurveyActivity extends Activity implements OnClickListener {

	private Button stopButton, repeatButton, nextButton;
	private FrameLayout fragmentFrame;
	private ProgressBar progressbar;
	private String surveyName;
	private int questionNumber;
	private Fragment questionFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey);
		
		stopButton = (Button) findViewById(R.id.bStop);
		stopButton.setOnClickListener(this);
		repeatButton = (Button) findViewById(R.id.bRepeat);
		repeatButton.setOnClickListener(this);
		nextButton = (Button) findViewById(R.id.bNext);
		nextButton.setOnClickListener(this);
		//fragmentFrame = (FrameLayout) findViewById(R.id.questionFragment);
		
		Bundle args = getIntent().getExtras();
		surveyName = args.getString("survey");
		questionNumber = args.getInt("questionNumber");
		
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
			break;
		case R.id.bNext:
			break;
		}		
	}
	
	private void saveSurvey(){
		//save survey for resume
	}
	
	private void loadQuestion(int questionNumber){
		Fragment newFragment = new QuestionYesNoFragment();
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.add(R.id.questionFragment, newFragment).commit();
	}
}
