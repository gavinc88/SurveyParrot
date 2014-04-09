package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RewardRedeemedActivity extends Activity {
	
	Context context;

	TextView lineName;
	TextView lineAmt;
	TextView lineInfo;
	
	String name;
	String amt;
	String info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_redeemed);
		context = this;
		
		name = " Amazon gift card";
		amt = "$10.00";
		info = "Was added to your account.";
		
		lineName = (TextView)findViewById(R.id.lineName);
		lineName.setText("Your " + name + " of");
		
		lineAmt = (TextView)findViewById(R.id.lineAmt);
		lineAmt.setText(amt);
		
		lineInfo = (TextView)findViewById(R.id.lineInfo);
		lineInfo.setText(info);
	}
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
//		Intent openMainActivity = new Intent(this, MainActivity.class);
//		openMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		openMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(openMainActivity);
	}

}
