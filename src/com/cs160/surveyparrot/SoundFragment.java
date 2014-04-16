package com.cs160.surveyparrot;

import android.app.Fragment;
import android.speech.RecognitionListener;

abstract class SoundFragment extends Fragment {
    public abstract void processWord(String in);
}
