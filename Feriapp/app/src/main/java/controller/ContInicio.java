package controller;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import logic.Datos;
import logic.LogFeriapp;
import model.Cuenta;
import view.Inicio;
import view.ListaCasetas;

public class ContInicio {


    public static void comprobarValores() {
        if (Inicio.txtUsuarioLogueo.getText().toString().equals("") || Inicio.txtContraseñaLogueo.getText().toString().equals("")){
            LogFeriapp.mensajeCampos("Debe rellenar todos los campos", Inicio.context);
        }
        else {
            LogFeriapp.comprobarUsuarioContrasenia();
        }

    }

    public static void comprobarSesion() {
        String id = Inicio.pref.getString("Id", "");
        String usuario = Inicio.pref.getString("Usuario", "");
        String contrasenia = Inicio.pref.getString("Contrasenia", "");
        String tipoUsuario = Inicio.pref.getString("TipoUsuario", "");
        if(!id.equals("") && !usuario.equals("") && !contrasenia.equals("") && !tipoUsuario.equals("")){
            List<Cuenta> listCuentas = new ArrayList<>();
            listCuentas.add(new Cuenta(Integer.parseInt(id),usuario,contrasenia,Integer.parseInt(tipoUsuario)));
            Datos.cuentas = listCuentas;
            LogFeriapp.traerCasetas();
        }
    }
}
