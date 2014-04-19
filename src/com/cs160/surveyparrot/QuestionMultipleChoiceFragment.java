package com.cs160.surveyparrot;

import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
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
        return rootview;
    }

    @Override
    public boolean processWord(String in) {
    	System.out.println("processing "+ in);
    	int choice = -1;
        if (in.equals("a")) {
            choice = 0;
        } else if (in.equals("b")) {
            choice = 1;
        } else if (in.equals("c") && numChoices >= 3) {
            choice = 2;
        } else if (in.equals("d") && numChoices >= 4) {
            choice = 3;
        } else if (in.equals("e") && numChoices >= 5) {
            choice = 4;
        } else {
            ArrayList<String[]> listOfWords= new ArrayList<String[]>(numChoices);
            // Populate list of words
            for (int i = 0; i < numChoices; i += 1) {
                listOfWords.set(i, choices[i].getText().toString().toLowerCase(Locale.US).split("\\W+"));
                // Search for matches
                for (String[] words : listOfWords) {
                    for (String word : words) {
                        if (word.equals(in)) { // Match
                            if (choice != -1) { // Redundant match
                                return false;
                            }
                            choice = i;
                            break; // Move on to words for next choice
                        }
                    }
                }
            }
            if (choice == -1) {
                return false;
            }
        }
        radioChoice.check(choices[choice].getId());
        radioChoice.postDelayed(new Runnable(){
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
