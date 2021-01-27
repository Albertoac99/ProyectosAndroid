package controller;

import logic.LogFeriapp;
import view.Inicio;

public class ContInicio {


    public static void comprobarValores() {
        if (Inicio.txtUsuarioLogueo.getText().toString().equals("") || Inicio.txtContraseñaLogueo.getText().toString().equals("")){
            LogFeriapp.mensajeCampos("Debe rellenar todos los campos", Inicio.context);
        }
        else {
            LogFeriapp.comprobarUsuarioContrasenia();
        }

    }
}
