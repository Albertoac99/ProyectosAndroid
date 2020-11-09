package com.aranda.ejercicioeuros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cambio;
    EditText euros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambio = findViewById(R.id.dolares);
        euros = findViewById(R.id.txtEuros);
    }

    public void ConversionDolares(View v){
        ImageButton Bdolares = findViewById(R.id.btnDolares);
        float resultado = Float.parseFloat(euros.getText().toString());
        cambio.setText("Tus "+ resultado+ " euros son " +resultado*1.17+ " dolares.");
    }

    public void ConversionYuan(View v){
        ImageButton Byuan = findViewById(R.id.btnYuan);
        float resultado = Float.parseFloat(euros.getText().toString());
        cambio.setText("Tus "+ resultado+ " euros son " +resultado*7.89+ " yuan.");
    }

    public void ConversionRupia(View v){
        ImageButton Brupia = findViewById(R.id.btnRupia);
        float resultado = Float.parseFloat(euros.getText().toString());
        cambio.setText("Tus "+ resultado+ " euros son " +resultado*85.97+ " rupias.");
    }

    public void ConversionLibra(View v){
        ImageButton Blibra = findViewById(R.id.btnLibra);
        float resultado = Float.parseFloat(euros.getText().toString());
        cambio.setText("Tus "+ resultado+ " euros son " +resultado*0.90+ " libras.");
    }

    public void ConversionYen(View v){
        ImageButton Byen = findViewById(R.id.btnYen);
        float resultado = Float.parseFloat(euros.getText().toString());
        cambio.setText("Tus "+ resultado+ " euros son " +resultado*123.25+ " yens.");
    }

    public void ConversionPeso(View v){
        ImageButton Bpeso = findViewById(R.id.btnPeso);
        float resultado = Float.parseFloat(euros.getText().toString());
        cambio.setText("Tus "+ resultado+ " euros son " +resultado*25.16+ " pesos.");
    }

}