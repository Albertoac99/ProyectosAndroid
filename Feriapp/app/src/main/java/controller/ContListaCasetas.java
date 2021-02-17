package controller;

import logic.LogFeriapp;

public class ContListaCasetas {

    public static void obtenerTipoCaseta(int i) {
        LogFeriapp.traerTipoCaseta(i);
    }

    public static void obtenerCasetasAforo() {
        LogFeriapp.traerCasetasAforo();
    }

    public static void obtenerCasetas() {
        LogFeriapp.traerCasetas();
    }
}
