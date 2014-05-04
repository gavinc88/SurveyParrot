package com.cs160.surveyparrot;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Fragment;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionYesNoFragment extends SoundFragment {
	
	private TextView question, questionNumber;
	private RadioGroup radioChoice; 
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_yes_no, container, false);
        questionNumber = (TextView) rootview.findViewById(R.id.questionNumber);
        question = (TextView) rootview.findViewById(R.id.question);
        radioChoice = (RadioGroup) rootview.findViewById(R.id.radioChoice);
        
        //define elements
        Bundle args = getArguments();
        questionNumber.setText("Question "+ args.getInt("questionNumber"));
        question.setText(args.getString("question"));
        return rootview;
    }

    @Override
    public boolean processWord(String in) {
    	System.out.println("yes no fragment processing "+ in);
        int choice;
        if (in.equals("yes")) {
            choice = R.id.yes;
        } else if (in.equals("no")) {
            choice = R.id.no;
        } else {
            return false;
        }
        radioChoice.check(choice);
        radioChoice.postDelayed(new Runnable(){
			@Override
			public void run() {
				((SurveyActivity) getActivity()).getNextQuestion();
			}
        }, 1500);
        return true;
    }

}
