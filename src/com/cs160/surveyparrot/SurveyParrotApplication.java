package com.cs160.surveyparrot;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SurveyParrotApplication extends Application {
	static String username = "";
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("SurveyParrotApplication instantiated");
	}
	
	public void savePreferences(String key, boolean value) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public void savePreferences(String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public void savePreferences(String key, int value) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	
	public boolean getBooleanPreferences(String key){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		return sharedPreferences.getBoolean(key, false);
	}
	
	public String getStringPreferences(String key){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		return sharedPreferences.getString(key, "");
	}
	
	public int getIntPreferences(String key){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		return sharedPreferences.getInt(key, -1);
	}
	
	public void removePreferences(String key){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.remove(key);
		editor.commit();
	}
}
