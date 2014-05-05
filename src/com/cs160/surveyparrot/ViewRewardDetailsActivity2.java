package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ViewRewardDetailsActivity2 extends Activity implements OnClickListener  {
	
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
		setContentView(R.layout.activity_view_reward_details_activity2);
		context = this;
		
		name = "Chipotle Coupon";
		amt = "$5 Burrito";
		details = "Earned on 03/02/14 from Fast Food Survey.";
		
		rewardName = (TextView)findViewById(R.id.rewardName2);
		rewardName.setText(name);
		
		amountValue = (TextView)findViewById(R.id.amountValue2);
		amountValue.setText(amt);
		
		rewardDetails = (TextView)findViewById(R.id.rewardDetails2);
		rewardDetails.setText(details);
		
		redeemButton = (Button)findViewById(R.id.redeemButton2);
		redeemButton.setOnClickListener(this);
		

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()){
		case R.id.redeemButton2:
			Intent openRedeemed = new Intent(this, RewardRedeemedActivity3.class);
	        startActivity(openRedeemed);
	        finish();
			break;
		}
		
	}

}
