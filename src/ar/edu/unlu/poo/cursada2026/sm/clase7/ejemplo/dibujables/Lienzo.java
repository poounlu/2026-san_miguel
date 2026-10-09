package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Simula una superficie donde se registran los dibujos. */
public class Lienzo {
    private final List<Dibujo> dibujos = new ArrayList<>();

    public void limpiar() {
        dibujos.clear();
    }

    public void agregarDibujo(Dibujo dibujo) {
        if (dibujo == null) {
            throw new IllegalArgumentException("El dibujo no puede ser null");
        }
        dibujos.add(dibujo);
    }

    public List<Dibujo> obtenerDibujos() {
        return Collections.unmodifiableList(new ArrayList<>(dibujos));
    }

    public void mostrar() {
        System.out.println("--- Contenido del lienzo ---");
        for (Dibujo dibujo : dibujos) {
            System.out.println(dibujo);
        }
    }
}
