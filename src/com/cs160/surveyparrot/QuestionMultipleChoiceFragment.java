package com.cs160.surveyparrot;

import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionMultipleChoiceFragment extends SoundFragment implements OnInitListener {
	
	private TextView question, questionNumber;
	private RadioGroup radioChoice;
	private RadioButton a,b,c,d,e;
	private RadioButton[] choices;
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
        
        a = (RadioButton) rootview.findViewById(R.id.radioButton1);
        b = (RadioButton) rootview.findViewById(R.id.radioButton2);
        c = (RadioButton) rootview.findViewById(R.id.radioButton3);
        d = (RadioButton) rootview.findViewById(R.id.radioButton4);
        e = (RadioButton) rootview.findViewById(R.id.radioButton5);
        
        choices = new RadioButton[5];
        choices[0] = a;
        choices[1] = b;
        choices[2] = c;
        choices[3] = d;
        choices[4] = e;
        
        for(int i = numChoices; i < 5; i++){
        	choices[i].setVisibility(View.GONE);
        }
        

        //tts = new TextToSpeech(getActivity(), this);
        //tts.speak("How do you like your peanut butter?", TextToSpeech.QUEUE_ADD, null);

        return rootview;
    }

    @Override
    public void processWord(String in) {
    	System.out.println("processing "+ in);
    	int letter;
        if (in.toUpperCase(Locale.US).equals("A")) {
            letter = R.id.radioButton1;
        } else if (in.toUpperCase(Locale.US).equals("B")) {
            letter = R.id.radioButton2;
        } else if (in.toUpperCase(Locale.US).equals("C") && numChoices >= 3) {
            letter = R.id.radioButton3;
        } else if (in.toUpperCase(Locale.US).equals("D") && numChoices >= 4) {
            letter = R.id.radioButton4;
        } else if (in.toUpperCase(Locale.US).equals("E") && numChoices >= 5) {
            letter = R.id.radioButton5;
        } else {
        	return;
        }
        radioChoice.check(letter);
        radioChoice.postDelayed(new Runnable(){
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
