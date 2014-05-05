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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class RedeemRewardsActivity extends Activity implements OnClickListener {
	
	
	Context context;
	ListView listview;
	ListView listview2;
	TextView details1;
	Button redeemButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_redeem_rewards);
		context = this;
		
		listview = (ListView) findViewById(R.id.ListView);
		listview2 = (ListView) findViewById(R.id.ListView2);
		String[] values = new String[]{"Amazon", "Jamba Juice", "Chipotle"};
		String[] values2 = new String[]{"Gift Card", "Coupon", "Coupon"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values2);
		listview.setAdapter(adapter);
		listview2.setAdapter(adapter2);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				final String item = (String) parent.getItemAtPosition(position);
				switch(position){
				case 0:
					Intent openList0 = new Intent(context, ViewRewardDetailsActivity0.class);
					startActivity(openList0);
					break;
				case 1:
					Intent openList1 = new Intent(context, ViewRewardDetailsActivity1.class);
					startActivity(openList1);
					break;
				case 2:
					Intent openList2 = new Intent(context, ViewRewardDetailsActivity2.class);
					startActivity(openList2);
					break;
				}
			}

		});
/**		
		details1 = (TextView)findViewById(R.id.viewDetails1);
		makeTextViewHyperlink(details1);
		details1.setOnClickListener(this);
		
		redeemButton = (Button)findViewById(R.id.redeemAll);
		redeemButton.setOnClickListener(this);
		**/
	}
/**
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.viewDetails1:
			Intent openDetails1 = new Intent(this, ViewRewardDetailsActivity0.class);
	        startActivity(openDetails1);
			break;
		case R.id.redeemAll:
			Intent openRedeemed = new Intent(this, RewardRedeemedActivity.class);
			startActivity(openRedeemed);
			finish();
			break;
		}
		
	}
	**/
	
	/**
	  * Sets a hyperlink style to the textview.
	  */
	public static void makeTextViewHyperlink(TextView tv) {
	  SpannableStringBuilder ssb = new SpannableStringBuilder();
	  ssb.append(tv.getText());
	  ssb.setSpan(new URLSpan("#"), 0, ssb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	  tv.setText(ssb, TextView.BufferType.SPANNABLE);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	} 
	

}
