package com.example.unitywrapper;

import android.content.Context;

public class PluginClass implements OnSpeechRecognitionPermissionListener, OnSpeechRecognitionListener
{
    private SpeechRecognition speechRecognition;
    private String resultText;

    public  PluginClass(Context unityContext)
    {
        speechRecognition = new SpeechRecognition(unityContext);
        speechRecognition.setSpeechRecognitionPermissionListener(this);
        speechRecognition.setSpeechRecognitionListener(this);
    }

    public static String GetTextFromPlugin(int number)
    {
        return "Number is::: " + number;
    }

    public  static void InitSpeechRecognition(Context unityContext)
    {

    }

    public void StartSpeechRecognition()
    {
        speechRecognition.startSpeechRecognition();
    }

    public  void  StioSpeechRecognition()
    {
        speechRecognition.stopSpeechRecognition();
    }

    @Override
    public void onPermissionGranted()
    {

    }

    @Override
    public void onPermissionDenied()
    {

    }

    @Override
    public void OnSpeechRecognitionStarted()
    {

    }

    @Override
    public void OnSpeechRecognitionStopped()
    {

    }

    @Override
    public void OnSpeechRecognitionFinalResult(String finalSentence)
    {
        resultText = finalSentence;
    }

    @Override
    public void OnSpeechRecognitionCurrentResult(String currentWord)
    {

    }

    @Override
    public void OnSpeechRecognitionError(int errorCode, String errorMsg)
    {

    }

}
