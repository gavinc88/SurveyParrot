package com.cs160.surveyparrot;

import java.util.Locale;

import android.app.Fragment;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
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

        TextToSpeech tts = new TextToSpeech(getActivity(), this);
        tts.speak("Rate from a scale of 1 to 5, with 5 being most frequent. How often do you eat snacks?", TextToSpeech.QUEUE_ADD, null);

        return rootview;
    }

    @Override
    public void processWord(String in) {
        int rate;
        if (in.toLowerCase(Locale.US).equals("one")) {
            rate = 1;
        } else if (in.toLowerCase(Locale.US).equals("two") && rating.getNumStars() > 1) { // This check for number stars assumes we want to expand our rating system to variable limits.
            rate = 2;
        } else if (in.toLowerCase(Locale.US).equals("three") && rating.getNumStars() > 2) {
            rate = 3;
        } else if (in.toLowerCase(Locale.US).equals("four") && rating.getNumStars() > 3) {
            rate = 4;
        } else if (in.toLowerCase(Locale.US).equals("five") && rating.getNumStars() > 4) {
            rate = 5;
        } else {
            return;
        }
        rating.setNumStars(rate);
        ((SurveyActivity) getActivity()).getNextQuestion();
    }

    @Override
    public void onInit(int status) {
    }

}
