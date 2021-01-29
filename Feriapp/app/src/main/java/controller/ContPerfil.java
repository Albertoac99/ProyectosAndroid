package controller;

import android.view.View;

import logic.LogFeriapp;
import view.Perfil;

public class ContPerfil {

    public static void cambiarUsuario() {
        LogFeriapp.actualizarUsuario();
    }

    public static void noEditable() {
        Perfil.btnGuardarCambios.setVisibility(View.INVISIBLE);
        Perfil.txtNuevoUsuario.setEnabled(false);
        Perfil.txtNuevaContrasenia.setEnabled(false);
    }

    public static void editar() {
        Perfil.txtNuevoUsuario.setEnabled(true);
        Perfil.txtNuevaContrasenia.setEnabled(true);
        Perfil.btnEditar.setVisibility(View.INVISIBLE);
        Perfil.btnGuardarCambios.setVisibility(View.VISIBLE);
    }
}
