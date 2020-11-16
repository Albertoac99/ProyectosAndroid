package com.aranda.activitiesestrellas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import model.Persona;


public class SegundaPantalla extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    RatingBar ratingBar2;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        edit1 =findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        ratingBar2=findViewById(R.id.ratingBar2);
        btnGuardar=findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Datos.gente.set(AdaptadorPersona.posicion, new Persona(edit1.getText().toString(),edit2.getText().toString(),ratingBar2.getRating()));
            }
        });
    }
}