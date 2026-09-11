package ar.edu.unlu.poo.cursada2026.sm.clase4.ejercicio1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {
    @Test
    public void testConsultasConStreamsFiltroPorMarca() {
        Catalogo catalogo = new Catalogo();
        catalogo.agregarArtefacto(new Artefacto("Apple", "iPhone 13", 800.0));
        catalogo.agregarArtefacto(new Artefacto("Apple", "iPhone 15 Pro", 1200.0));
        catalogo.agregarArtefacto(new Artefacto("Samsung", "Galaxy S24", 1000.0));

        List<Artefacto> apples = catalogo.filtrarPorMarca("Apple");
        assertEquals(2, apples.size());

        //Optional<Artefacto> masCaroApple = catalogo.buscarMasCaro("Apple");
//        assertTrue(masCaroApple.isPresent());
//        assertEquals("iPhone 15 Pro", masCaroApple.get().getModelo());
//        Optional<Artefacto> masCaroMotorola = catalogo.buscarMasCaro("Motorola");
//        assertTrue(masCaroMotorola.isEmpty());
    }

    @Test
    public void testConsultasConStreamsObtenerModelos() {
        Catalogo catalogo = new Catalogo();
        catalogo.agregarArtefacto(new Artefacto("Apple", "iPhone 13", 800.0));
        catalogo.agregarArtefacto(new Artefacto("Apple", "iPhone 15 Pro", 1200.0));
        catalogo.agregarArtefacto(new Artefacto("Samsung", "Galaxy S24", 1000.0));

        List<String> modelosApple = catalogo.obtenerModelos("Apple");
        assertTrue(modelosApple.contains("iPhone 13"));
        assertTrue(modelosApple.contains("iPhone 15 Pro"));
        assertFalse(modelosApple.contains("Motorola"));

        //Optional<Artefacto> masCaroApple = catalogo.buscarMasCaro("Apple");
//        assertTrue(masCaroApple.isPresent());
//        assertEquals("iPhone 15 Pro", masCaroApple.get().getModelo());
//        Optional<Artefacto> masCaroMotorola = catalogo.buscarMasCaro("Motorola");
//        assertTrue(masCaroMotorola.isEmpty());
    }

}
