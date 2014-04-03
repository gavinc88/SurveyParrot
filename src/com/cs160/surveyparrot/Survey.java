package com.cs160.surveyparrot;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

//Survey Object
public class Survey {
	
	private String name;
	private ArrayList<Question> questions;
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Question> getQuestions(){
		return questions;
	}
}
