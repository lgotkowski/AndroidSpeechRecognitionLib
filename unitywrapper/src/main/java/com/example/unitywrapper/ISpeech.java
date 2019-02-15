package com.example.unitywrapper;

public interface ISpeech
{
    public  void OnDebugCallback(String text);

    public void OnSpeechRecognitionStarted();

    public void OnSpeechRecognitionFinalResult(String text);

    public void OnReadyForSpeech();

    public void OnBeginningOfSpeech();

    public void OnEndOfSpeech();

    public void OnSpeechRecognitionStopped();

    public void OnSpeechRecognitionError(String errorMsg);
}
