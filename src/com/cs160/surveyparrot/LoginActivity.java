package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity implements OnClickListener {

	private Button loginButton, createAccountButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		loginButton = (Button) findViewById(R.id.bLogin);
		loginButton.setOnClickListener(this);
		createAccountButton = (Button) findViewById(R.id.bCreateAccount);
		createAccountButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bLogin:
			Intent openMainActivity = new Intent(this, MainActivity.class);
	        startActivity(openMainActivity);
			break;
		case R.id.bCreateAccount:
			Intent createAccount = new Intent(this, CreateUserActivity.class);
	        startActivity(createAccount);
			break;
		}		
	}
}
