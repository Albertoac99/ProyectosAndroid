package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.aranda.feriapp.R;

public class Inicio extends AppCompatActivity {

    EditText txtUsuarioLogueo;
    EditText txtContraseñaLogueo;
    Button btnIniciaSesion;
    Button btnRegistro;
    Button btnSinSesion;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuarioLogueo = findViewById(R.id.txtUsuarioLogueo);
        txtContraseñaLogueo = findViewById(R.id.txtContraseñaLogueo);
        btnIniciaSesion = findViewById(R.id.btnIniciaSesion);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnSinSesion = findViewById(R.id.btnSinSesion);

        btnIniciaSesion.setOnClickListener( v -> {

        intent = new Intent(getApplicationContext(), ListaCasetas.class);

        startActivity(intent);

        });

        btnRegistro.setOnClickListener( v -> {

        intent = new Intent(getApplicationContext(), CrearUsuario.class);

        startActivity(intent);

        });

        btnSinSesion.setOnClickListener( v -> {

        intent = new Intent(getApplicationContext(), CrearUsuario.class);

        startActivity(intent);

        });

    }
}