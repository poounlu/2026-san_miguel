package ar.edu.unlu.poo.cursada2026.sm.clase2.ejercicio02;

public class Mascota {
    private String chip;
    private String nombre;
    private String especie;
    private int edad;

    public Mascota(String chip, String nombre, String especie, int edad) {
        this.chip = chip;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String getChip() {
        return chip;
    }

    public String getNombre() {
        return nombre;
    }
}
