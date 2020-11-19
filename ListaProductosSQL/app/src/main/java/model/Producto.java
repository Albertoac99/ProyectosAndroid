package model;

public class Producto {

    private String nombre;
    private String precio;
    private float estrellas;
    private boolean fragil;
    private int envoltorio;
    private int ciudad;
    private int proveedor;

    public Producto(String nombre, String precio, float estrellas, boolean fragil, int envoltorio, int ciudad, int proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.estrellas = estrellas;
        this.fragil = fragil;
        this.envoltorio = envoltorio;
        this.ciudad = ciudad;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public int getEnvoltorio() {
        return envoltorio;
    }

    public void setEnvoltorio(int envoltorio) {
        this.envoltorio = envoltorio;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", estrellas=" + estrellas +
                ", fragil=" + fragil +
                ", envoltorio='" + envoltorio + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }
}
