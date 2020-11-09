package com.aranda.mezclasonido;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MediaPlayer musica = MediaPlayer.create(this,R.raw.peces2);
        musica.start();


        Button btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(v -> musica.start());

        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(v ->{
            try {
                musica.stop();
                musica.prepare();
                musica.seekTo(0);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        
    }
}