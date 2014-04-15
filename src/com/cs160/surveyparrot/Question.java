package com.cs160.surveyparrot;

//Question object
public class Question {
	
	public static final int QUESTION_TYPE_MULTIPLE_CHOICE = 0;
	public static final int QUESTION_TYPE_RATING = 1;
	public static final int QUESTION_TYPE_YES_NO = 2;
	
	private String question;
	private int type;
	private int numChoice;
	private String[] answers;
	
	public Question(String question, int type){
		this.question = question;
		this.type = type;
		this.numChoice = 0;
		this.answers = null;
	}
	
	//constructor for multiple choice questions
	public Question(String question, int type, int numChoice){
		this.question = question;
		this.type = type;
		this.numChoice = numChoice;
		this.answers = new String[numChoice];
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
	
	public void addAnswer(int num, String answer){
		if(num <= numChoice){	
			this.answers[num-1] = answer;
		}else{
			System.out.println("can't add answer "+ num);
		}
	}
	
	public String getAnswer(int num){
		if(num <= numChoice){	
			return answers[num-1];
		}else{
			System.out.println("can't find answer "+ num);
			return "";
		}
		
	}

}
