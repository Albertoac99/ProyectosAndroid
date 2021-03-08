package com.example.chatmedacfirebase;

public class Mensaje {
    private String sNombre;
    private String sHora;
    private String sMensaje;
    private String urlImagen;

    public Mensaje() {
    }

    public Mensaje(String sNombre, String sHora, String sMensaje, String urlImagen) {
        this.sNombre = sNombre;
        this.sHora = sHora;
        this.sMensaje = sMensaje;
        this.urlImagen = urlImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsHora() {
        return sHora;
    }

    public void setsHora(String sHora) {
        this.sHora = sHora;
    }

    public String getsMensaje() {
        return sMensaje;
    }

    public void setsMensaje(String sMensaje) {
        this.sMensaje = sMensaje;
    }
}
