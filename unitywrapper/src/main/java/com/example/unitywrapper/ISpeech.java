package com.example.unitywrapper;

public interface ISpeech
{
    public void onReceivedSpeech(String text);

    public  void onDebugCallback(String text);
}
