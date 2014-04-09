package com.cs160.surveyparrot;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class CreateUserBasicInfoFragment extends Fragment implements OnClickListener {
	
	private Button chooseDate;
	private TextView birthday;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_create_user_basic_info, container, false);
        chooseDate = (Button) rootview.findViewById(R.id.bChooseDate);
        chooseDate.setOnClickListener(this);
        birthday = (TextView) rootview.findViewById(R.id.birthday);
        return rootview;
    }
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bChooseDate:
			final Dialog dialog = new Dialog(this.getActivity());
			dialog.setContentView(R.layout.dialog_date_picker);
			dialog.setTitle("Choose Birthday:");
			
			DatePicker dp = (DatePicker) dialog.findViewById(R.id.datePicker);
						
			Button confirmButton = (Button) dialog.findViewById(R.id.bConfirm);
			confirmButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					birthday.setText("11/21/1992");
					dialog.dismiss();
				}
			});
 
			dialog.show();
			break;
		}		
	}
	
}