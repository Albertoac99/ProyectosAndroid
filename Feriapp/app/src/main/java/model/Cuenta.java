package model;

public class Cuenta {

    private String usuario;
    private String contrasenia;
    private boolean fotoPerfil;

    public Cuenta(String usuario, String contrasenia, boolean fotoPerfil) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.fotoPerfil = fotoPerfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(boolean fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", fotoPerfil=" + fotoPerfil +
                '}';
    }
}
