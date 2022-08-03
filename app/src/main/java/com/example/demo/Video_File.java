package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video_File extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_file);


        VideoView videoView = findViewById(R.id.videoView);

        /** To set video using the path

         String videoPath = "android.resource://" + getPackageName()+ "/raw/sample_video";

         videoView.setVideoPath(videoPath);
         videoView.start(); */



        // To set video using URI path

        String videoPath = "android.resource://" + getPackageName()+ "/raw/sample_video2";
        Uri videoURI = Uri.parse(videoPath);

        videoView.setVideoPath(String.valueOf(videoURI));
        videoView.start();

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }
}