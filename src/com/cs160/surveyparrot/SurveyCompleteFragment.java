package com.cs160.surveyparrot;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SurveyCompleteFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_survey_complete, container, false);
        SurveyActivity.surveyId += 1;
        if (SurveyActivity.surveyId >= Survey.surveys.size()) {
            SurveyActivity.surveyId = 0;
        }
        return rootview;
    }

}
