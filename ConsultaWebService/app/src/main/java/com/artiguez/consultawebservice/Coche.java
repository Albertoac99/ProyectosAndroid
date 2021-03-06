package com.artiguez.consultawebservice;

public class Coche {

    private int id_coche;
    private String marca;
    private String modelo;
    private Integer potencia;

    public Coche() {
        this.id_coche = 0;
        this.marca = "";
        this.modelo = "";
        this.potencia = 0;
    }

    public int getId_coche() {
        return id_coche;
    }

    public void setId_coche(int id_coche) {
        this.id_coche = id_coche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id_coche=" + id_coche +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}
