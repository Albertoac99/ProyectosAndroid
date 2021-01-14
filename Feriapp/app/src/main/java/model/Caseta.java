package model;

public class Caseta {

    private int numeroCaseta;
    private String nombreCaseta;
    private String nombreCalle;
    private int aforoMaximo;
    private int aforoActual;
    private String horario;

    public Caseta(int numeroCaseta, String nombreCaseta, String nombreCalle, int aforoMaximo, int aforoActual, String horario) {
        this.numeroCaseta = numeroCaseta;
        this.nombreCaseta = nombreCaseta;
        this.nombreCalle = nombreCalle;
        this.aforoMaximo = aforoMaximo;
        this.aforoActual = aforoActual;
        this.horario = horario;
    }

    public int getNumeroCaseta() {
        return numeroCaseta;
    }

    public void setNumeroCaseta(int numeroCaseta) {
        this.numeroCaseta = numeroCaseta;
    }

    public String getNombreCaseta() {
        return nombreCaseta;
    }

    public void setNombreCaseta(String nombreCaseta) {
        this.nombreCaseta = nombreCaseta;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public int getAforoActual() {
        return aforoActual;
    }

    public void setAforoActual(int aforoActual) {
        this.aforoActual = aforoActual;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Caseta{" +
                "numeroCaseta=" + numeroCaseta +
                ", nombreCaseta='" + nombreCaseta + '\'' +
                ", nombreCalle='" + nombreCalle + '\'' +
                ", aforoMaximo=" + aforoMaximo +
                ", aforoActual=" + aforoActual +
                ", horario='" + horario + '\'' +
                '}';
    }
}
