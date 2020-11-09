package com.aranda.testingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    TextView txtMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        txtMensaje = findViewById(R.id.txtMensaje);


    }

    @Override
    protected void onResume() {
        super.onResume();
        txtMensaje.setText(""+Datos.cont);
        System.out.println(Datos.cont);
        Datos.cont++;
    }
}