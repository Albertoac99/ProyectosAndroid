package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    public static SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer musica = MediaPlayer.create(this,R.raw.sevillana);
        musica.start();
        context = getApplicationContext();
        // Acceso a las Preferencias
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        // Leer de las Preferencias
        ContInicio.comprobarSesion();


        txtUsuarioLogueo = findViewById(R.id.txtUsuarioLogueo);
        txtContraseñaLogueo = findViewById(R.id.txtContraseñaLogueo);
        btnIniciaSesion = findViewById(R.id.btnIniciaSesion);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnIniciaSesion.setOnClickListener(v -> {
            ContInicio.comprobarValores();

        });

        btnRegistro.setOnClickListener(v -> {

            intent = new Intent(getApplicationContext(), CrearUsuario.class);

            startActivity(intent);

        });

    }
}