package com.cs160.surveyparrot;

import android.os.Parcel;
import android.os.Parcelable;

//Survey Object
public class Survey {
	
	private String name;
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
}
