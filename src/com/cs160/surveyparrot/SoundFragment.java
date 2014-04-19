package com.cs160.surveyparrot;

import android.app.Fragment;
import android.speech.RecognitionListener;

abstract class SoundFragment extends Fragment {
    /** Return TRUE if word was parsed and consumed. */
    public abstract boolean processWord(String in);
}
