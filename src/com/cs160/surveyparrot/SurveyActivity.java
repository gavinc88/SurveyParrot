package com.cs160.surveyparrot;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SurveyActivity extends Activity implements OnClickListener {

	private Button stopButton, repeatButton, nextButton;
	private FrameLayout fragmentFrame;
	private ProgressBar progressbar;
	private TextView progressMessage;
	private String surveyName;
	private int questionNumber;
	private ArrayList<Question> questions;
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
		progressMessage = (TextView) findViewById(R.id.surveyProgressText);
		progressbar = (ProgressBar) findViewById(R.id.surveyProgress);
		
		Bundle args = getIntent().getExtras();
		surveyName = args.getString("survey");
		questionNumber = args.getInt("questionNumber");
		
		getSurveyQuestions(surveyName); //make server call to get survey info

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
			System.out.println("repeat pressed");
			break;
		case R.id.bNext:
			getNextQuestion();
			break;
		}		
	}
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		saveSurvey();
	}
	
	private void saveSurvey(){
		//save survey for resume
	}
	
	private void getSurveyQuestions(String surveyName){
		questions = new ArrayList<Question>(3);
		questions.add(new Question(getResources().getString(R.string.question1), Question.QUESTION_TYPE_MULTIPLE_CHOICE));
		questions.add(new Question(getResources().getString(R.string.question2), Question.QUESTION_TYPE_RATING));
		questions.add(new Question(getResources().getString(R.string.question3), Question.QUESTION_TYPE_YES_NO));
		progressbar.setMax(questions.size());
	}
	
	private void loadQuestion(int questionNumber){
		progressMessage.setText("Question "+questionNumber+" of "+questions.size());
		progressbar.setProgress(questionNumber);
		if(questions.get(questionNumber-1).getType() == Question.QUESTION_TYPE_MULTIPLE_CHOICE){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionMultipleChoiceFragment();
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}else if(questions.get(questionNumber-1).getType() == Question.QUESTION_TYPE_RATING){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionRatingFragment();
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}else if(questions.get(questionNumber-1).getType() == Question.QUESTION_TYPE_YES_NO){
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			questionFragment = new QuestionYesNoFragment();
			ft.replace(R.id.questionFragment, questionFragment).commit();
		}
	}
	
	//our audio processor from each fragment should call getActivity().getNextQuestion() to automatically proceed
	public void getNextQuestion(){
		questionNumber++;
		if(questionNumber > questions.size()){
			progressMessage.setText("Survey Completed!");
			repeatButton.setVisibility(View.INVISIBLE);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			Fragment newFragment = new SurveyCompleteFragment();
			ft.replace(R.id.questionFragment, newFragment).commit();
		}else{
			loadQuestion(questionNumber);
		}
	}

}
