package com.aranda.soundcloud;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SoundPool spGrillos = new SoundPool.Builder().setMaxStreams(10).build();
        int spGrillosID = spGrillos.load(this,R.raw.grillos,1);

        SoundPool spWa = new SoundPool.Builder().setMaxStreams(10).build();
        int spWaID = spWa.load(this,R.raw.whatsapp,1);

        Button btnWhatsapp = findViewById(R.id.btnWa);

        btnWhatsapp.setOnClickListener(v -> {
            spWa.play(spWaID,1,1,1,0,1);
        });

        Button btnGrillos = findViewById(R.id.btnGrillos);

        btnGrillos.setOnClickListener(v -> {
            spGrillos.play(spGrillosID,1,1,1,0,1);
        });


    }
}