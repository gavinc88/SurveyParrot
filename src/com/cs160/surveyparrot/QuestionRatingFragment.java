package com.cs160.surveyparrot;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Fragment;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class QuestionRatingFragment extends SoundFragment implements OnInitListener {
	
	private TextView question, questionNumber;
	private RatingBar rating;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_rating, container, false);
        questionNumber = (TextView) rootview.findViewById(R.id.questionNumber);
        question = (TextView) rootview.findViewById(R.id.question);
        rating = (RatingBar) rootview.findViewById(R.id.ratingBar);
        
        //define elements
        Bundle args = getArguments();
        questionNumber.setText("Question "+ args.getInt("questionNumber"));
        question.setText(args.getString("question"));
        return rootview;
    }

    @Override
    public boolean processWord(String in) {
    	System.out.println("processing "+ in);
        int rate;
        if (in.equals("1")) {
            rate = 1;
        } else if (in.equals("2")) {
            rate = 2;
        } else if (in.equals("3")) {
            rate = 3;
        } else if (in.equals("4")) {
            rate = 4;
        } else if (in.equals("5")) {
            rate = 5;
        } else {
           return false;
        }
        rating.setRating(rate);
        rating.postDelayed(new Runnable(){
			@Override
			public void run() {
			    ((SurveyActivity) getActivity()).getNextQuestion();
			}        	
        }, 1500);
        return true;
    }

    @Override
    public void onInit(int status) {
    }

}
