package com.aranda.practicaevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button btnAceptar;
    CheckBox checkFactura;
    Switch swchSonido;
    FloatingActionButton fabCorreo;
    RadioGroup rgrPago;
    RadioButton radElement;
    Spinner lstColores;
    RatingBar rtbEstrellas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press_btnAceptar();
            }
        });

        checkFactura = findViewById(R.id.checkFactura);
        checkFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press_checkFactura();
            }
        });

        swchSonido = findViewById(R.id.swchSonido);
        swchSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has cambiado el estado del switch" +
                        "", Toast.LENGTH_SHORT).show();
            }
        });

        fabCorreo = findViewById(R.id.fabCorreo);
        fabCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "enviar correo", Toast.LENGTH_SHORT).show();
            }
        });

        rgrPago = findViewById(R.id.rgrPago);
        rgrPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radElement = (RadioButton)group.findViewById(checkedId);
                sel_Pago();

            }
        });

        lstColores = findViewById(R.id.lstColores);
        lstColores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item_color_selected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rtbEstrellas = findViewById(R.id.rtbEstrellas);
        rtbEstrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                estrella(rating);
            }
        });

    }

    private void estrella(float rating) {
        Toast.makeText(getApplicationContext(), "Estrellas: " +rating, Toast.LENGTH_SHORT).show();
    }

    private void item_color_selected(int position) {
        Toast.makeText(getApplicationContext(), "Color : " +color(position), Toast.LENGTH_SHORT).show();
    }

    private String color(int position) {
        if (position==0){
            return "Rojo";
        }
        else if(position==1){
            return "Verde";
        }
        else{
            return "Azul";
        }
    }

    private void sel_Pago() {
        Toast.makeText(getApplicationContext(), "Nueva forma de pago: " +radElement.getText(), Toast.LENGTH_SHORT).show();
    }

    private void press_checkFactura() {
        Toast.makeText(getApplicationContext(), "Factura " +checkFactura.isChecked(), Toast.LENGTH_SHORT).show();
    }

    private void press_btnAceptar() {

        Log.i("Alberto", "Has pulsado el boton");
        Log.i("Alberto","Color: "+lstColores.getSelectedItem().toString());
        Log.i("Alberto", "Estrellas: "+rtbEstrellas.getRating());
        Toast.makeText(getApplicationContext(),"Has pulsado el botoncito",Toast.LENGTH_LONG).show();
    }
}
