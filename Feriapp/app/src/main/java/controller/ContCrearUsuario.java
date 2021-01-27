package controller;

import logic.LogFeriapp;
import view.CrearUsuario;
import view.Inicio;

public class ContCrearUsuario {


    public static void comprobarValores() {
        if (CrearUsuario.txtUsuarioRegistro.getText().toString().equals("") || CrearUsuario.txtContraseñaRegistro.getText().toString().equals("")){
            LogFeriapp.mensajeCampos("Debe rellenar todos los campos", Inicio.context);
        }
        else {
            LogFeriapp.comprobarUsuario();
        }

    }
}
