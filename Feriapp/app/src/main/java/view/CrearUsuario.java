package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.aranda.feriapp.R;

public class CrearUsuario extends AppCompatActivity {

    EditText txtUsuarioRegistro;
    EditText txtContraseñaRegistro;
    Button btnCrearUsuario;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        txtUsuarioRegistro = findViewById(R.id.txtUsuarioRegistro);
        txtContraseñaRegistro = findViewById(R.id.txtContraseñaRegistro);
        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);

        btnCrearUsuario.setOnClickListener( v -> {

            intent = new Intent(getApplicationContext(), Inicio.class);

            startActivity(intent);

        });

    }
}