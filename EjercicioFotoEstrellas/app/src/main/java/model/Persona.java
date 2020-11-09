package model;

public class Persona {

    private String Titulo;
    private String Subtitulo;
    private float Estrellas;

    public Persona(String titulo, String subtitulo, float estrellas) {
        Titulo = titulo;
        Subtitulo = subtitulo;
        Estrellas = estrellas;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        Subtitulo = subtitulo;
    }

    public float getEstrellas() {
        return Estrellas;
    }

    public void setEstrellas(float estrellas) {
        Estrellas = estrellas;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Titulo='" + Titulo + '\'' +
                ", Subtitulo='" + Subtitulo + '\'' +
                ", Estrellas=" + Estrellas +
                '}';
    }

}
