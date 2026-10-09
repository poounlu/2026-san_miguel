package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

import java.util.ArrayList;
import java.util.List;

/**
 * Administra objetos que cumplen el contrato Dibujable.
 * No depende de clases concretas como Circulo, Rectangulo, Casa o Auto.
 */
public class AdministradorDibujos {
    private final Lienzo lienzo;
    private final List<Dibujable> objetos = new ArrayList<>();
    private Dibujable seleccionado;

    public AdministradorDibujos(Lienzo lienzo) {
        if (lienzo == null) {
            throw new IllegalArgumentException("El lienzo no puede ser null");
        }
        this.lienzo = lienzo;
    }

    /** Incorpora el objeto al sistema y lo dibuja. */
    public void agregar(Dibujable objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException("El objeto no puede ser null");
        }
        objetos.add(objeto);
        dibujar(objeto);
    }

    /** Selecciona el último objeto agregado que contiene el punto indicado. */
    public Dibujable seleccionar(int x, int y) {
        seleccionado = null;
        for (int indice = objetos.size() - 1; indice >= 0; indice--) {
            Dibujable objeto = objetos.get(indice);
            if (objeto.estaEn(x, y)) {
                seleccionado = objeto;
                break;
            }
        }
        return seleccionado;
    }

    /** Mueve el objeto seleccionado y actualiza los dibujos del lienzo. */
    public void mover(int x, int y) {
        if (seleccionado == null) {
            throw new IllegalStateException("Primero debe seleccionar un objeto");
        }
        seleccionado.moverA(x, y);
        redibujar();
    }

    public Dibujo dibujar(Dibujable objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException("El objeto no puede ser null");
        }
        Dibujo dibujo = objeto.dibujar();
        lienzo.agregarDibujo(dibujo);
        return dibujo;
    }

    /** Reconstruye el lienzo para que no queden dibujos en posiciones anteriores. */
    public void redibujar() {
        lienzo.limpiar();
        for (Dibujable objeto : objetos) {
            dibujar(objeto);
        }
    }

    public Lienzo obtenerLienzo() { return lienzo; }

    public Dibujable obtenerSeleccionado() { return seleccionado; }
}
