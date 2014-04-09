package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ViewRewardDetailsActivity extends Activity implements OnClickListener  {
	
	Context context;
	
	TextView rewardName;
	TextView amountValue;
	TextView rewardDetails;
	Button redeemButton;
	Button backButton;
	Button homeButton;
	
	String name;
	String amt;
	String details;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_reward_details);
		context = this;
		
		name = "Amazon Gift Card";
		amt = "$20.00";
		details = "Earned on 04/05/14 from Snacks Survey.";
		
		rewardName = (TextView)findViewById(R.id.rewardName);
		rewardName.setText(name);
		
		amountValue = (TextView)findViewById(R.id.amountValue);
		amountValue.setText(amt);
		
		rewardDetails = (TextView)findViewById(R.id.rewardDetails);
		rewardDetails.setText(details);
		
		redeemButton = (Button)findViewById(R.id.redeemButton);
		redeemButton.setOnClickListener(this);
		

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()){
		case R.id.redeemButton:
			Intent openRedeemed = new Intent(this, RewardRedeemedActivity.class);
	        startActivity(openRedeemed);
	        finish();
			break;
		}
		
	}

}
