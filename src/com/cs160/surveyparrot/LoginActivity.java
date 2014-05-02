package com.cs160.surveyparrot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {
	
	final Context context = this;

	private Button loginButton, createAccountButton;
	private EditText usernameField;
	private EditText passwordField;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(isLoggedIn()){
			Intent openMainActivity = new Intent(this, MainActivity.class);
			SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
			SurveyParrotApplication.username = app.getStringPreferences("username");
			startActivity(openMainActivity);
			finish();
		}else{
			setContentView(R.layout.activity_login);
			
			loginButton = (Button) findViewById(R.id.bLogin);
			loginButton.setOnClickListener(this);
			createAccountButton = (Button) findViewById(R.id.bCreateAccount);
			createAccountButton.setOnClickListener(this);
			
			usernameField = (EditText)findViewById(R.id.enterUsername);
			passwordField = (EditText)findViewById(R.id.enterPassword);
		}
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bLogin:
			
			if (usernameField.getText().toString().isEmpty() || passwordField.getText().toString().isEmpty()){
				showAlert();
			} else {
				Intent openMainActivity = new Intent(this, MainActivity.class);
				SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
				app.savePreferences("username", usernameField.getText().toString());
				SurveyParrotApplication.username = usernameField.getText().toString();
				startActivity(openMainActivity);
				finish();
			}
			break;
		case R.id.bCreateAccount:
			Intent createAccount = new Intent(this, CreateUserActivity.class);
	        startActivity(createAccount);
	        finish();
			break;
		}		
	}

	private void showAlert() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		// set title
		alertDialogBuilder.setTitle("Please enter the correct username and password.");

		// set dialog message
		alertDialogBuilder.setMessage("Your username and password are incorrect.")
				.setCancelable(false)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}
	
	public boolean isLoggedIn(){
		SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
		//if username exists, the the user is logged in
		if(!app.getStringPreferences("username").equals("")){
			return true;
		}
		return false;
	}

	
	

}
