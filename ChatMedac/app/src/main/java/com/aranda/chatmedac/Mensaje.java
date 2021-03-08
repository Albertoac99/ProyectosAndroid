package com.aranda.chatmedac;

public class Mensaje {

    private String mensaje;
    private String nombre;
    private String hora;
    private String urlImagen;

    public Mensaje() {
    }

    public Mensaje(String mensaje, String nombre, String hora, String urlImagen) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.hora = hora;
        this.urlImagen = urlImagen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
