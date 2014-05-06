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
	
	int rewardNumber;
	int type;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_redeemed);
		context = this;

		Bundle args = getIntent().getExtras();
		name = args.getString("RewardName");
		amt = args.getString("Amount");
		type = args.getInt("Type");
		rewardNumber = args.getInt("RewardNumber");
		name = " Amazon gift card";
		amt = "$10.00";
		info = "was added to your account.";
		
		lineName = (TextView)findViewById(R.id.lineName);
		lineAmt = (TextView)findViewById(R.id.lineAmt);
		lineInfo = (TextView)findViewById(R.id.lineInfo);
		
		if(type == 1){
			//gift card
			lineName.setText("Your " + name + " gift card of");
			lineAmt.setText(amt);
		}else{
			//coupon
			lineName.setText("Your " + name + " coupon of");
			lineAmt.setText(amt);
		}
	}
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
	}

}
