package logic;

import android.widget.Toast;

import view.CrearUsuario;

public class LogFeriapp {
    public static void mensajeCampos() {
        Toast.makeText(CrearUsuario.context, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
    }
}
