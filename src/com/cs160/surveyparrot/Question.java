package com.cs160.surveyparrot;

//Question object
public class Question {
	
	public static final int QUESTION_TYPE_MULTIPLE_CHOICE = 0;
	public static final int QUESTION_TYPE_RATING = 1;
	public static final int QUESTION_TYPE_YES_NO = 2;
	
	private String question;
	private int type;
	private int numChoice;
	
	public Question(String question, int type){
		this.question = question;
		this.type = type;
		this.numChoice = 0;
	}
	
	//constructor for multiple choice questions
	public Question(String question, int type, int numChoice){
		this.question = question;
		this.type = type;
		this.numChoice = numChoice;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public int getType(){
		return type;
	}
	
	public int getNumChoice(){
		return numChoice;
	}

}
