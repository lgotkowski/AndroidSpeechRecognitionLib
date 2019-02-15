package com.example.unitywrapper;

import android.content.Context;
import android.os.Bundle;


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
        //speechRecognition.useOnlyOfflineRecognition(offline);
        speechCallback = unitySpeechCallback;
    }

    public void SetOffline(boolean offlineState)
    {
        speechRecognition.useOnlyOfflineRecognition(offlineState);
    }

    public void StartSpeechRecognition()
    {
        speechRecognition.startSpeechRecognition();
        //speechCallback.OnDebugCallback("startSpeechRecognition");
    }

    public  void  StopSpeechRecognition()
    {
        //speechCallback.OnDebugCallback("StopSpeechRecognition");
        speechRecognition.stopSpeechRecognition();
    }

    @Override
    public void onPermissionGranted()
    {
        speechCallback.OnDebugCallback("onPermissionGranted");
    }

    @Override
    public void onPermissionDenied()
    {
        speechCallback.OnDebugCallback("onPermissionDenied");
    }

    @Override
    public void OnSpeechRecognitionStarted()
    {
        speechCallback.OnSpeechRecognitionStarted();
    }

    @Override
    public void OnSpeechRecognitionStopped()
    {
        speechCallback.OnSpeechRecognitionStopped();
    }

    @Override
    public void OnSpeechRecognitionFinalResult(String finalSentence)
    {
        //speechCallback.OnDebugCallback("OnSpeechRecognitionFinalResult");
        speechCallback.OnSpeechRecognitionFinalResult(finalSentence);
    }

    @Override
    public void OnSpeechRecognitionCurrentResult(String currentWord)
    {
        //speechCallback.onDebugCallback("OnSpeechRecognitionCurrentResult");
    }

    @Override
    public void OnSpeechRecognitionError(int errorCode, String errorMsg)
    {
        speechCallback.OnSpeechRecognitionError(errorMsg);
    }

    @Override
    public void OnReadyForSpeech(Bundle bundle)
    {
        speechCallback.OnReadyForSpeech();
    }

    @Override
    public void OnBeginningOfSpeech()
    {
        speechCallback.OnBeginningOfSpeech();
    }

    @Override
    public void OnEndOfSpeech()
    {
        speechCallback.OnEndOfSpeech();
    }
}
