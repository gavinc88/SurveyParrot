package com.cs160.surveyparrot;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class RewardRedeemedActivity3 extends Activity {

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
		setContentView(R.layout.activity_reward_redeemed_activity2);

		name = " coupon";
		amt = "Chipotle";
		info = "Was ready to print. Please check your email.";
		
		lineName = (TextView)findViewById(R.id.lineName);
		lineName.setText("Your coupon of");
		
		lineAmt = (TextView)findViewById(R.id.lineAmt);
		lineAmt.setText(amt);
		
		lineInfo = (TextView)findViewById(R.id.lineInfo);
		lineInfo.setText(info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reward_redeemed_activity3, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_reward_redeemed_activity3, container,
					false);
			return rootView;
		}
	}

}
