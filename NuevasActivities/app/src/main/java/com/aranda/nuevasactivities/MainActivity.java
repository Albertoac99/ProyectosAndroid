package com.aranda.nuevasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnMarcarTelefono).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Activity_MarcarTelefono.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnLlamarTelefono).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Activity_LlamarTelefono.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnWhatsapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ActivityWhatsapp.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnEnviarSMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Ativity_SMS.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnEnviarEmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Activity_Email.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnGoogleMaps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Activity_GoogleMaps.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnNavegadorWeb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Activity_Web.class);
                startActivity(i);
            }
        });
















    }
}