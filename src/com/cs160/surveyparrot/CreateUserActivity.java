package com.cs160.surveyparrot;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CreateUserActivity extends Activity implements OnClickListener {

	private Button cancelButton, nextButton;
	private ProgressBar progressbar;
	private TextView progressMessage;
	private int step;
	private Fragment createUserFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_user);
		cancelButton = (Button) findViewById(R.id.bCancel);
		cancelButton.setOnClickListener(this);
		nextButton = (Button) findViewById(R.id.bNext);
		nextButton.setOnClickListener(this);
		progressMessage = (TextView) findViewById(R.id.createUserProgressText);
		progressbar = (ProgressBar) findViewById(R.id.createUserProgress);
		progressbar.setMax(3);
		step = 1;
		loadStep(step);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bCancel:
			Intent openLoginActivity = new Intent(this, LoginActivity.class);
	        startActivity(openLoginActivity);
			break;
		case R.id.bNext:
			if (step == 1) {
				EditText usernameField = (EditText)findViewById(R.id.username);
				SurveyParrotApplication.username = usernameField.getText().toString();
			} else if (step == 4 ) {
				Intent openMainActivity = new Intent(this, MainActivity.class);
		        startActivity(openMainActivity);
			}		
			step++;
			loadStep(step);
			break;
		}		
	}
	
	@Override
	public void onBackPressed(){
		step--;
		if(step <= 0){
			finish();
		}else{
			loadStep(step);
		}
	}
	
	private void loadStep(int stepNum){
		if(step == 1){
			progressMessage.setText("Step 1 of 3");
			progressbar.setProgress(1);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			createUserFragment = new CreateUserAccountInfoFragment();
			ft.replace(R.id.createUserFragment, createUserFragment).commit();
		}else if(step == 2){
			progressMessage.setText("Step 2 of 3");
			progressbar.setProgress(2);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			createUserFragment = new CreateUserBasicInfoFragment();
			ft.replace(R.id.createUserFragment, createUserFragment).commit();
		}else if(step == 3){
			progressMessage.setText("Step 3 of 3");
			progressbar.setProgress(3);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			createUserFragment = new CreateUserMoreFragment();
			ft.replace(R.id.createUserFragment, createUserFragment).commit();
		
		} else if (step > 3) {
			progressMessage.setText("");
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			createUserFragment = new CreateUserAccountCompleteFragment();
			ft.replace(R.id.createUserFragment, createUserFragment).commit();
		}
	}

}