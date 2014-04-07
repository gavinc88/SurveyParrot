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
import android.widget.TextView;

public class QuestionYesNoFragment extends SoundFragment implements OnInitListener {
	
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

        TextToSpeech tts = new TextToSpeech(getActivity(), this);
        tts.speak("Yes or no? Do you like potato chips?", TextToSpeech.QUEUE_ADD, null);

        return rootview;
    }

    @Override
    public void processWord(String in) {
        int choice;
        if (in.toLowerCase(Locale.US).equals("yes")) {
            choice = 0;
        } else if (in.toLowerCase(Locale.US).equals("no")) {
            choice = 1;
        } else {
            return;
        }
        radioChoice.check(choice);
        ((SurveyActivity) getActivity()).getNextQuestion();
    }

    @Override
    public void onInit(int status) {
    }

}
