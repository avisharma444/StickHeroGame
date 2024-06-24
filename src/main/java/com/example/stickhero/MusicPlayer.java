package com.example.stickhero;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class MusicPlayer implements Runnable {

    public String getSong() {
        return "mujic.mp3";
    }

    MediaPlayer mediaPlayer;


    @Override
    public void run() {
        String ms = getSong();
        Media h = new Media(Paths.get(ms).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }
}
