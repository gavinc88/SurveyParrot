package com.cs160.surveyparrot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RedeemRewardsActivity extends Activity implements OnClickListener {
	
	
	Context context;
	
	TextView details1;
	Button redeemButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_redeem_rewards);
		context = this;
		
		details1 = (TextView)findViewById(R.id.viewDetails1);
		makeTextViewHyperlink(details1);
		details1.setOnClickListener(this);
		
		redeemButton = (Button)findViewById(R.id.redeemAll);
		redeemButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.viewDetails1:
			Intent openDetails1 = new Intent(this, ViewRewardDetailsActivity.class);
	        startActivity(openDetails1);
			break;
		case R.id.redeemAll:
			Intent openRedeemed = new Intent(this, RewardRedeemedActivity.class);
			startActivity(openRedeemed);
			finish();
			break;
		}
		
	}
	
	/**
	  * Sets a hyperlink style to the textview.
	  */
	public static void makeTextViewHyperlink(TextView tv) {
	  SpannableStringBuilder ssb = new SpannableStringBuilder();
	  ssb.append(tv.getText());
	  ssb.setSpan(new URLSpan("#"), 0, ssb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	  tv.setText(ssb, TextView.BufferType.SPANNABLE);
	} 
	

}
