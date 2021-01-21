package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.aranda.feriapp.R;

import controller.ContCrearUsuario;

public class CrearUsuario extends AppCompatActivity {

    public static EditText txtUsuarioRegistro;
    public static EditText txtContraseñaRegistro;
    Button btnCrearUsuario;
    public static Switch swchDuenio;
    Intent intent;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        context = getApplicationContext();
        txtUsuarioRegistro = findViewById(R.id.txtUsuarioRegistro);
        txtContraseñaRegistro = findViewById(R.id.txtContraseniaRegistro);
        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);
        swchDuenio = findViewById(R.id.swchDueño);

        btnCrearUsuario.setOnClickListener( v -> {

            if(ContCrearUsuario.crearUsuario()){
                intent = new Intent(getApplicationContext(), Inicio.class);

                startActivity(intent);
            }
            else{
                ContCrearUsuario.mensajeCampos();
            }



        });

    }
}