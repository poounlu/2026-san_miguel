package ar.edu.unlu.poo.cursada2026.sm.clase4.ejercicio2;

public class Libro {
    private String titulo;
    private int anio;
    private String autor;

    public Libro(String titulo, int anio, String autor) {
        this.titulo = titulo;
        this.anio = anio;
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getAnio() {
        return this.anio;
    }

    public String getAutor() {
        return this.autor;
    }
}