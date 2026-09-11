package ar.edu.unlu.poo.cursada2026.sm.clase4.ejercicio1;

public class Artefacto {
    private String marca;
    private String modelo;
    private Double precio;

    public Artefacto(String marca, String modelo, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPrecio() {
        return precio;
    }
}
