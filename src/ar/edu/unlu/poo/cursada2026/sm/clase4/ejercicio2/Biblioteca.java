package ar.edu.unlu.poo.cursada2026.sm.clase4.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro l) {
        this.libros.add(l);

    }

    public List<String> titulosDesde(int anio) {
        return this.libros.stream()
                .filter(l -> l.getAnio() >= anio)
                .map(Libro::getTitulo)
                .toList();
    }
    public Set<String> autoresUnicos() {
        return this.libros.stream()
                .map(Libro::getAutor)
                .collect(Collectors.toSet());
    }
}