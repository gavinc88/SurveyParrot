package com.cs160.surveyparrot;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionMultipleChoiceFragment extends SoundFragment implements OnInitListener {
	
	private TextView question, questionNumber;
	private RadioGroup radioChoice;
	private int numChoices;
	private TextToSpeech tts;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_multiple_choice, container, false);
        questionNumber = (TextView) rootview.findViewById(R.id.questionNumber);
        question = (TextView) rootview.findViewById(R.id.question);
        radioChoice = (RadioGroup) rootview.findViewById(R.id.radioChoice);
        
        //define elements
        Bundle args = getArguments();
        questionNumber.setText("Question "+ args.getInt("questionNumber"));
        question.setText(args.getString("question"));
        numChoices = args.getInt("numChoice");

        tts = new TextToSpeech(getActivity(), this);
        tts.speak("How do you like your peanut butter?", TextToSpeech.QUEUE_ADD, null);

        return rootview;
    }

    @Override
    public void processWord(String in) {
    }

    @Override
    public void onInit(int status) {
    }

}
