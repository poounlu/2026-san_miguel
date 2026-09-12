package ar.edu.unlu.poo.cursada2026.sm.clase4.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    Biblioteca biblioteca;
    @BeforeEach
    void setUp() {
        biblioteca= new Biblioteca();
        biblioteca.agregarLibro(new Libro("El Aleph", 1949, "Jorge Luis Borges"));
        biblioteca.agregarLibro(new Libro("Ficciones", 1944, "Jorge Luis Borges"));
        biblioteca.agregarLibro(new Libro("Cien Años de Soledad", 1967, "Gabriel García Márquez"));
        biblioteca.agregarLibro(new Libro("Patrones de Diseño", 2004,"Erich Gamma"));
    }

    @Test
    public void testConsultasBibliotecaStreams() {

        List<String> recientes = biblioteca.titulosDesde(1960);
        assertEquals(2, recientes.size());
        assertTrue(recientes.contains("Cien Años de Soledad"));
        assertTrue(recientes.contains("Patrones de Diseño"));

        Set<String> autores = biblioteca.autoresUnicos();
        assertEquals(3, autores.size());
        assertTrue(autores.contains("Jorge Luis Borges"));
    }
}