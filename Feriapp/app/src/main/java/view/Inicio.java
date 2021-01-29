package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aranda.feriapp.R;

import controller.ContInicio;
import logic.Datos;
import logic.LogFeriapp;


public class Inicio extends AppCompatActivity {

    public static EditText txtUsuarioLogueo;
    public static EditText txtContraseñaLogueo;
    Button btnIniciaSesion;
    Button btnRegistro;
    Intent intent;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        txtUsuarioLogueo = findViewById(R.id.txtUsuarioLogueo);
        txtContraseñaLogueo = findViewById(R.id.txtContraseñaLogueo);
        btnIniciaSesion = findViewById(R.id.btnIniciaSesion);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnIniciaSesion.setOnClickListener( v -> {
            ContInicio.comprobarValores();
        });

        btnRegistro.setOnClickListener( v -> {

        intent = new Intent(getApplicationContext(), CrearUsuario.class);

        startActivity(intent);

        });


    }
}