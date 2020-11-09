package com.aranda.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ImageButton btnSuma;
    ImageButton btnResta;
    ImageButton btnMultiplicacion;
    ImageButton btnDivision;
    EditText nmb1;
    EditText nmb2;
    TextView lblResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nmb1 = findViewById(R.id.nmb1);
        nmb2 = findViewById(R.id.nmb2);
        lblResultado = findViewById(R.id.lblResultado);

        btnSuma = findViewById(R.id.btnSuma);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fResultado = Float.parseFloat(nmb1.getText().toString()) + Float.parseFloat(nmb2.getText().toString());
                lblResultado.setText(""+ fResultado);
            }
        });

        btnResta = findViewById(R.id.btnResta);

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fResultado = Float.parseFloat(nmb1.getText().toString()) - Float.parseFloat(nmb2.getText().toString());
                lblResultado.setText(""+ fResultado);
            }
        });

        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fResultado = Float.parseFloat(nmb1.getText().toString()) * Float.parseFloat(nmb2.getText().toString());
                lblResultado.setText(""+ fResultado);
            }
        });

        btnDivision = findViewById(R.id.btnDivision);

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fResultado = Float.parseFloat(nmb1.getText().toString()) / Float.parseFloat(nmb2.getText().toString());
                lblResultado.setText(""+ fResultado);
            }
        });


    }
}