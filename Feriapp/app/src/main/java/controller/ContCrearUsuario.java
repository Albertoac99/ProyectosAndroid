package controller;

import android.content.Intent;

import logic.LogFeriapp;
import view.CrearUsuario;
import view.Inicio;

public class ContCrearUsuario {


    public static boolean crearUsuario() {
        boolean bExito;

        if (CrearUsuario.txtUsuarioRegistro.getText().toString().equals("")){

            bExito = false;
        }
        else if(CrearUsuario.txtContraseñaRegistro.getText().toString().equals("")){

            bExito = false;
        }
        else{

            bExito = true;
        }
        return bExito;
    }

    public static void mensajeCampos() {

        LogFeriapp.mensajeCampos();
    }
}
