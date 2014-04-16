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

        //TextToSpeech tts = new TextToSpeech(getActivity(), this);
        //tts.speak("Rate from a scale of 1 to 5, with 5 being most frequent. How often do you eat snacks?", TextToSpeech.QUEUE_ADD, null);

        return rootview;
    }

    @Override
    public void processWord(String in) {
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
           return;
        }
//        if (in.toLowerCase(Locale.US).equals("one")|| in.equals("1")) {
//            rate = 1;
//        } else if (in.toLowerCase(Locale.US).equals("two") && rating.getNumStars() > 1 || in.equals("2")) { // This check for number stars assumes we want to expand our rating system to variable limits.
//            rate = 2;
//        } else if (in.toLowerCase(Locale.US).equals("three") && rating.getNumStars() > 2 || in.equals("3")) {
//            rate = 3;
//        } else if (in.toLowerCase(Locale.US).equals("four") && rating.getNumStars() > 3 || in.equals("4")) {
//            rate = 4;
//        } else if (in.toLowerCase(Locale.US).equals("five") && rating.getNumStars() > 4 || in.equals("5")) {
//            rate = 5;
//        } else {
//           return;
//        }
        rating.setRating(rate);
        //rating.setNumStars(rate);
        rating.postDelayed(new Runnable(){
			@Override
			public void run() {
				((SurveyActivity) getActivity()).getNextQuestion();
			}        	
        }, 1500);
        //((SurveyActivity) getActivity()).getNextQuestion();
    }

    @Override
    public void onInit(int status) {
    }

}
