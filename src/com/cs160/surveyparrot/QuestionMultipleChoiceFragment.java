package com.cs160.surveyparrot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionMultipleChoiceFragment extends SoundFragment {
	
	private TextView question, questionNumber;
	private RadioGroup radioChoice;
	private RadioButton[] choices;
	private int numChoices;
	
	private HashSet<String> options;
	private String[] letters = {"a", "b", "c", "d", "e", "alpha", "bravo", "charlie", "delta", "echo"}; //NATO phonetics
	

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
        choices = new RadioButton[] {(RadioButton) rootview.findViewById(R.id.radioButton1), (RadioButton) rootview.findViewById(R.id.radioButton2), (RadioButton) rootview.findViewById(R.id.radioButton3), (RadioButton) rootview.findViewById(R.id.radioButton4), (RadioButton) rootview.findViewById(R.id.radioButton5)};
        for(int i = numChoices; i < 5; i++){
        	choices[i].setVisibility(View.INVISIBLE);
        }
        choices[0].setText(args.getString("answera"));
        choices[1].setText(args.getString("answerb"));
        if (numChoices > 2)
            choices[2].setText(args.getString("answerc"));
        if (numChoices> 3)
            choices[3].setText(args.getString("answerd"));
        if (numChoices > 4)
            choices[4].setText(args.getString("answere"));
        options = new HashSet<String>();
        for(int i = 0; i < numChoices; i++){
        	options.add(letters[i]);
        	options.add(letters[i+5]);
        }
        
        return rootview;
    }

    @Override
    public boolean processWord(String in) {
    	System.out.println("multiple choice processing "+ in);
    	int choice = -1;
        if (in.equals("alpha") || in.equals("a")) {
            choice = 0;
        } else if (in.equals("bravo") || in.equals("b")) {
            choice = 1;
        } else if (in.equals("charlie") || in.equals("c") && numChoices >= 3) {
            choice = 2;
        } else if (in.equals("delta") || in.equals("d") && numChoices >= 4) {
            choice = 3;
        } else if (in.equals("echo") || in.equals("e") && numChoices >= 5) {
            choice = 4;
//        } else if ((in.equals("c") && numChoices < 3) || (in.equals("d") && numChoices < 4) || (in.equals("e") && numChoices < 5)){
//        	
//        	return true;
        } else {
//            ArrayList<String[]> listOfWords= new ArrayList<String[]>(numChoices);
//            // Populate list of words
//            for (int i = 0; i < numChoices; i += 1) {
//                listOfWords.add(i, choices[i].getText().toString().toLowerCase(Locale.US).split(" "));
//                // Search for matches
//                for (String[] words : listOfWords) {
//                	for (String word : words) {
//                    	if(options.contains(word)){
//                    		System.out.println(word + "found");
//                    		return processWord(word);
//                    	}
//                    }
//                }
//            }
        	String[] words = in.toLowerCase().split(" ");
        	for (String word : words) {
        		System.out.print(word + ", ");
            	if(options.contains(word)){
            		System.out.println(word + "found");
            		return processWord(word);
            	}
            }
        	System.out.println();
           // ((SurveyActivity) getActivity()).read("Sorry, " + in + " is not a valid answer. Please try again.", false);
            return false;
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

    
}
