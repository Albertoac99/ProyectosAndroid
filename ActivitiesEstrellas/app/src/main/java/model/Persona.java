package model;

public class Persona {

    private String Nombre;
    private String Apellidos;
    private float Estrellas;

    public Persona(String nombre, String apellidos, float estrellas) {

        Nombre = nombre;
        Apellidos = apellidos;
        Estrellas = estrellas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
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
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Estrellas=" + Estrellas +
                '}';
    }
}
