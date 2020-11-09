package com.aranda.funiconalidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView info;
    EditText viejo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.LabelInfo);
        viejo = findViewById(R.id.txtEdad);
    }

    public void pressBtNAceptar(View v){
        Log.i("Alberto", "Has pulsado el botón ACEPTAR !");
        Button b1 = findViewById(R.id.buttonAceptar);
        b1.setText("ACEPTADO");
        String contenido = viejo.getText().toString();
        info.setText("TIENES " +contenido+" AÑOS");
    }

    public void pressBtNCancelar(View v){
        Log.i("Alberto", "Has pulsado el boton CANCELAR !");
        Button b2 = findViewById(R.id.ButtonCancelar);
        b2.setText("CANCELADO");
        info.setText("HAS PULSADO CANCELAR");
    }


}