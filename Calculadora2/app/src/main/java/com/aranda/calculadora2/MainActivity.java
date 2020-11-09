package com.aranda.calculadora2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nmb1;
    EditText nmb2;
    TextView lblResultado;
    Spinner spnOperaciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nmb1 = findViewById(R.id.nmb1);
        nmb2 = findViewById(R.id.nmb2);
        lblResultado = findViewById(R.id.lblResultado);

        spnOperaciones = findViewById(R.id.spnOperaciones);

        spnOperaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                operacion(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void operacion(int position) {

        if(position==0){
            lblResultado.setText("");
        }
        else if(position==1){
            float fResultado = Float.parseFloat(nmb1.getText().toString()) + Float.parseFloat(nmb2.getText().toString());
            lblResultado.setText(""+ fResultado);
        }
        else if(position==2){
            float fResultado = Float.parseFloat(nmb1.getText().toString()) - Float.parseFloat(nmb2.getText().toString());
            lblResultado.setText(""+ fResultado);
        }
        else if(position==3){
            float fResultado = Float.parseFloat(nmb1.getText().toString()) * Float.parseFloat(nmb2.getText().toString());
            lblResultado.setText(""+ fResultado);
        }
        else{
            float fResultado = Float.parseFloat(nmb1.getText().toString()) / Float.parseFloat(nmb2.getText().toString());
            lblResultado.setText(""+ fResultado);
        }

    }
}