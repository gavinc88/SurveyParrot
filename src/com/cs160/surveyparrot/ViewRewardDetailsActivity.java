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
	
	int rewardNumber;
	int type;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_reward_details);
		context = this;
		
		Bundle args = getIntent().getExtras();
		name = args.getString("RewardName");
		amt = args.getString("Amount");
		details = args.getString("RewardDetails");
		type = args.getInt("Type");
		rewardNumber = args.getInt("RewardNumber");
		
		rewardName = (TextView)findViewById(R.id.rewardName0);
		rewardName.setText(name);
		
		amountValue = (TextView)findViewById(R.id.amountValue0);
		amountValue.setText(amt);
		
		rewardDetails = (TextView)findViewById(R.id.rewardDetails0);
		rewardDetails.setText(details);
		
		redeemButton = (Button)findViewById(R.id.redeemButton0);
		redeemButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {	
		switch(arg0.getId()){
		case R.id.redeemButton0:
			SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
			String tempName = "reward"+rewardNumber+"redeemed";
			app.savePreferences(tempName, true);
			
			Intent openRedeemed = new Intent(this, RewardRedeemedActivity.class);
			openRedeemed.putExtra("RewardName", name);
			openRedeemed.putExtra("Amount", amt);
			openRedeemed.putExtra("Type", type);
	        startActivity(openRedeemed);
	        finish();
			break;
		}
		
	}

}
