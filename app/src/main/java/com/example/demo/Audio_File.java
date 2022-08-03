package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Audio_File extends AppCompatActivity {

    Button btnPlay, btnPause, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_file);


        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);


        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String audioPath = "android.resource://" + getPackageName() + "/raw/hare_krishna_relaxing_theme";
        String onlineAudioPath = "https://gaana.com/song/kesariya-from-brahmastra";

        Uri audioURI = Uri.parse(audioPath);
        Uri onlineURI = Uri.parse(onlineAudioPath);

        try {
            mp.setDataSource(this, audioURI);
            //          mp.setDataSource(this, onlineURI);
            mp.prepare();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.pause();
            }
        });


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.start();
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.pause();
                mp.seekTo(0);
            }
        });
    }
}