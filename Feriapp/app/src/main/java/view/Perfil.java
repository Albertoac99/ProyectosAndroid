package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.aranda.feriapp.R;

import controller.ContPerfil;
import logic.Datos;

public class Perfil extends AppCompatActivity {
    public static EditText txtNuevaContrasenia;
    public static EditText txtNuevoUsuario;
    public static Button btnEditar;
    Button btnCambiaFoto;
    public static Button btnGuardarCambios;
    public static Context context;
    public static ImageView imgFotoPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        context = getApplicationContext();
        imgFotoPerfil = findViewById(R.id.imgFotoPerfil);
        txtNuevaContrasenia = findViewById(R.id.txtNuevaContrasenia);
        txtNuevoUsuario = findViewById(R.id.txtNuevoUsuario);
        btnEditar = findViewById(R.id.btnEditarCampos);
        btnCambiaFoto = findViewById(R.id.btnCambiarFoto);
        btnGuardarCambios = findViewById(R.id.btnGuardarCambios);
        ContPerfil.noEditable();

        txtNuevoUsuario.setText(Datos.cuentas.get(0).getUsuario());
        txtNuevaContrasenia.setText(Datos.cuentas.get(0).getContrasenia());

        btnEditar.setOnClickListener(v ->{
            ContPerfil.editar();
        });

        btnGuardarCambios.setOnClickListener(v -> {
            ContPerfil.cambiarUsuario();

        });

    }
}