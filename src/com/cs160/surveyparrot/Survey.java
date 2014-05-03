package com.cs160.surveyparrot;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

//Survey Object
public class Survey {
	
	public String name;
	private ArrayList<Question> questions = new ArrayList<Question>();
	public static ArrayList<Survey> surveys = makeSurveys();
	
	public ArrayList<Question> getQuestions(){
		return questions;
	}

	public void addQuestion(Question q) {
	    questions.add(q);
	}

    private static ArrayList<Survey> makeSurveys() {
        ArrayList<Survey> out = new ArrayList<Survey>();

        Survey arthropods = new Survey();
        arthropods.name = "Arthropods";
        arthropods.addQuestion(new Question("Are arthropods invertebrates?", Question.QUESTION_TYPE_YES_NO));
        arthropods.addQuestion(new Question("Are crabs arthropods?", Question.QUESTION_TYPE_YES_NO));
        arthropods.addQuestion(new Question("How many legs do arthropods have?", Question.QUESTION_TYPE_MULTIPLE_CHOICE, 4).addAnswer(0, "A. 6").addAnswer(1, "B. 8").addAnswer(2, "C. 10").addAnswer(3, "D. Varies between species."));
        arthropods.addQuestion(new Question("What material is the exoskeleton made of?", Question.QUESTION_TYPE_MULTIPLE_CHOICE, 3).addAnswer(0, "A. Bone").addAnswer(1, "B. Chitin").addAnswer(2, "C. Cartilage"));
        arthropods.addQuestion(new Question("Which arthopod phyla is extinct?", Question.QUESTION_TYPE_MULTIPLE_CHOICE, 5).addAnswer(0, "A. Hexapods").addAnswer(1, "B. Crustaceans").addAnswer(2, "C. Myriapods").addAnswer(3, "D. Trilobytes").addAnswer(4, "E. Chelicerates"));
        out.add(arthropods);

        Survey politics = new Survey();
        politics.name = "Politics";
        politics.addQuestion(new Question("5 being high, rate from 1 to 5 how politically active are you?", Question.QUESTION_TYPE_RATING));
        politics.addQuestion(new Question("Which political party do you identify most with?", Question.QUESTION_TYPE_MULTIPLE_CHOICE, 3).addAnswer(0, "A. Republican").addAnswer(1, "B. Democratic").addAnswer(2, "C. Other"));
        politics.addQuestion(new Question("Yes or no: do you know the name of your district's representative in the House of Representatives?", Question.QUESTION_TYPE_YES_NO));
        politics.addQuestion(new Question("Yes or no: does the Republican party hold the majority in the Senate?", Question.QUESTION_TYPE_YES_NO));
        politics.addQuestion(new Question("5 being most, rate from 1 to 5 how satisfied are you with the current president?", Question.QUESTION_TYPE_RATING));
        politics.addQuestion(new Question("Which political party do you identify most with?", Question.QUESTION_TYPE_MULTIPLE_CHOICE, 3).addAnswer(0, "A. Republican").addAnswer(1, "B. Democratic").addAnswer(2, "C. Other"));
        politics.addQuestion(new Question("What is your opinion about the degree of emphasis on foreign relations that the U.S. should take?", Question.QUESTION_TYPE_MULTIPLE_CHOICE, 3).addAnswer(0, "A. Just right the way it is.").addAnswer(1, "B. Should interact more with other countries.").addAnswer(2, "C. Should interact less with other countries."));
        out.add(politics);
        return out;
    }
}
