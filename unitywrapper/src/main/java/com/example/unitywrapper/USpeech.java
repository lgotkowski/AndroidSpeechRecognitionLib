package com.example.unitywrapper;

import android.content.Context;


public class USpeech implements OnSpeechRecognitionPermissionListener, OnSpeechRecognitionListener
{
    private static  USpeech instance;
    private SpeechRecognition speechRecognition;
    private ISpeech speechCallback;

    public USpeech(Context unityContext, ISpeech unitySpeechCallback)
    {
        speechRecognition = new SpeechRecognition(unityContext);
        speechRecognition.setSpeechRecognitionPermissionListener(this);
        speechRecognition.setSpeechRecognitionListener(this);
        speechCallback = unitySpeechCallback;
    }

    public void StartSpeechRecognition()
    {
        speechRecognition.startSpeechRecognition();
        speechCallback.onDebugCallback("Starting.");
    }

    public  void  StopSpeechRecognition()
    {
        speechCallback.onDebugCallback("Stopping.");
        speechRecognition.stopSpeechRecognition();
    }

    @Override
    public void onPermissionGranted()
    {
        speechCallback.onDebugCallback("onPermissionGranted.");
    }

    @Override
    public void onPermissionDenied()
    {
        speechCallback.onDebugCallback("onPermissionDenied.");
    }

    @Override
    public void OnSpeechRecognitionStarted()
    {
        speechCallback.onDebugCallback("OnSpeechRecognitionStarted.");
    }

    @Override
    public void OnSpeechRecognitionStopped()
    {
        speechCallback.onDebugCallback("OnSpeechRecognitionStopped.");
    }

    @Override
    public void OnSpeechRecognitionFinalResult(String finalSentence)
    {
        speechCallback.onDebugCallback("OnSpeechRecognitionFinalResult.");
        speechCallback.onReceivedSpeech(finalSentence);
    }

    @Override
    public void OnSpeechRecognitionCurrentResult(String currentWord)
    {
        speechCallback.onDebugCallback("OnSpeechRecognitionCurrentResult.");
    }

    @Override
    public void OnSpeechRecognitionError(int errorCode, String errorMsg)
    {
        speechCallback.onDebugCallback("OnSpeechRecognitionError.");
    }
}
