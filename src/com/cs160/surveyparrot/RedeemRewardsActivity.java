package com.cs160.surveyparrot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class RedeemRewardsActivity extends Activity implements OnClickListener {
	
	Context context;
	ListView listview;
	public static List<Map<String, String>> data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_redeem_rewards);
		context = this;
		
		listview = (ListView) findViewById(R.id.rewards_listview);
		
		data = new ArrayList<Map<String, String>>();
		
		SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
		Map<String, String> datum;
		if(!app.getBooleanPreferences("reward1redeemed")){
			datum = new HashMap<String, String>(2);
	        datum.put("First Line", "Amazon");
	        datum.put("Second Line","Gift Card ($10)");
	        data.add(datum);
		}
		
		if(!app.getBooleanPreferences("reward2redeemed")){
			datum = new HashMap<String, String>(2);
	        datum.put("First Line", "Jamba Juice");
	        datum.put("Second Line","Coupon (Buy 1 Get 1 Free)");
	        data.add(datum);
		}       
        
		if(!app.getBooleanPreferences("reward3redeemed")){
	        datum = new HashMap<String, String>(2);
	        datum.put("First Line", "Chipotle");
	        datum.put("Second Line","Coupon ($5 Burrito)");
	        data.add(datum);
		}
		
		if(!app.getBooleanPreferences("reward4redeemed")){
            datum = new HashMap<String, String>(2);
	        datum.put("First Line", "iTunes");
	        datum.put("Second Line","Gift Card ($20)");
	        data.add(datum);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2, 
                new String[] {"First Line", "Second Line" }, 
                new int[] {android.R.id.text1, android.R.id.text2 });
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
				//final String item = (String) parent.getItemAtPosition(position);
				Intent openRewardsDetail = new Intent(context, ViewRewardDetailsActivity.class);
				String reward = data.get(position).get("First Line");
				if(reward == "Amazon"){				
					openRewardsDetail.putExtra("RewardName", "Amazon");
					openRewardsDetail.putExtra("Amount", "$10.00");
					openRewardsDetail.putExtra("RewardDetails", "Earned on 04/05/14 from Snacks Survey.");
					openRewardsDetail.putExtra("Type", 1); //1 = Gift Card, 2 = Coupon
					openRewardsDetail.putExtra("RewardNumber", 1);
				}else if(reward == "Jamba Juice"){
					openRewardsDetail.putExtra("RewardName", "Jamba Juice");
					openRewardsDetail.putExtra("Amount", "Buy One Get One Free");
					openRewardsDetail.putExtra("RewardDetails", "Earned on 04/05/14 from Snacks Survey.");
					openRewardsDetail.putExtra("Type", 2);
					openRewardsDetail.putExtra("RewardNumber", 2);
				}else if(reward == "Chipotle"){
					openRewardsDetail.putExtra("RewardName", "Chipotle");
					openRewardsDetail.putExtra("Amount", "$5 Burrito");
					openRewardsDetail.putExtra("RewardDetails", "Earned on 04/05/14 from Snacks Survey.");
					openRewardsDetail.putExtra("Type", 2);
					openRewardsDetail.putExtra("RewardNumber", 3);
				}else if(reward == "iTunes"){		
					openRewardsDetail.putExtra("RewardName", "iTunes");
					openRewardsDetail.putExtra("Amount", "$20.00");
					openRewardsDetail.putExtra("RewardDetails", "Earned on 04/05/14 from Snacks Survey.");
					openRewardsDetail.putExtra("Type", 1);
					openRewardsDetail.putExtra("RewardNumber", 4);
				}
				startActivity(openRewardsDetail);
			}
		});
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		data = new ArrayList<Map<String, String>>();
		
		SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
		Map<String, String> datum;
		if(!app.getBooleanPreferences("reward1redeemed")){
			datum = new HashMap<String, String>(2);
	        datum.put("First Line", "Amazon");
	        datum.put("Second Line","Gift Card ($10)");
	        data.add(datum);
		}
		
		if(!app.getBooleanPreferences("reward2redeemed")){
			datum = new HashMap<String, String>(2);
	        datum.put("First Line", "Jamba Juice");
	        datum.put("Second Line","Coupon (Buy 1 Get 1 Free)");
	        data.add(datum);
		}       
        
		if(!app.getBooleanPreferences("reward3redeemed")){
	        datum = new HashMap<String, String>(2);
	        datum.put("First Line", "Chipotle");
	        datum.put("Second Line","Coupon ($5 Burrito)");
	        data.add(datum);
		}
		
		if(!app.getBooleanPreferences("reward4redeemed")){
            datum = new HashMap<String, String>(2);
	        datum.put("First Line", "iTunes");
	        datum.put("Second Line","Gift Card ($20)");
	        data.add(datum);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2, 
                new String[] {"First Line", "Second Line" }, 
                new int[] {android.R.id.text1, android.R.id.text2 });
		
		listview.setAdapter(adapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.rewards_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.renew) {
			SurveyParrotApplication app = (SurveyParrotApplication) getApplication();
			app.removePreferences("reward1redeemed");
			app.removePreferences("reward2redeemed");
			app.removePreferences("reward3redeemed");
			app.removePreferences("reward4redeemed");
			onResume();
			return true;
		}
		return false;
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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	} 
	

}
