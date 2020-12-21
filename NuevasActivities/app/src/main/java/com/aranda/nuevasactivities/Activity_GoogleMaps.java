package com.aranda.nuevasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.content.Intent.ACTION_VIEW;

public class Activity_GoogleMaps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        Spinner lstCiudades = findViewById(R.id.lstCiudades);
        String [] ciudades = {"Sevilla", "Madrid", "Londres"};

        lstCiudades.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ciudades));

        final int LATITUD = 0;
        final int LONGITUD = 1;
        double [][] coords = new double[3][2];

        //Sevilla
        coords[0][LATITUD] = 37.3754338;
        coords[0][LONGITUD] = -5.9901634;

        //Madrid
        coords[1][LATITUD] = 40.4380637;
        coords[1][LONGITUD] = -3.7497478;

        //Londres
        coords[2][LATITUD] = 51.5287714;
        coords[2][LONGITUD] = -0.2420232;

        findViewById(R.id.btnAccionGoogleMaps).setOnClickListener(view ->{

            int ciudad = lstCiudades.getSelectedItemPosition();

            String geo = "geo:" +coords[ciudad][LATITUD]+","+coords[ciudad][LONGITUD]+"?q=" +coords[ciudad][LATITUD]+","+coords[ciudad][LONGITUD];

            Intent i = new Intent(ACTION_VIEW, Uri.parse(geo));
            i.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(i);

        });


    }
}