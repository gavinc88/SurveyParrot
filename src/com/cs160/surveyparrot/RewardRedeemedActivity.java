package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RewardRedeemedActivity extends Activity implements OnClickListener  {
	
	Context context;
	
	Button backButton;
	Button homeButton;

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
		
		name = "Amazon gift card";
		amt = "$20.00";
		info = "has been applied to your Amazon account.";
		
		lineName = (TextView)findViewById(R.id.lineName);
		lineName.setText("Your " + name + " of");
		
		lineAmt = (TextView)findViewById(R.id.lineAmt);
		lineAmt.setText(amt);
		
		lineInfo = (TextView)findViewById(R.id.lineInfo);
		lineInfo.setText(info);
		

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()){

		}
		
	}

}
