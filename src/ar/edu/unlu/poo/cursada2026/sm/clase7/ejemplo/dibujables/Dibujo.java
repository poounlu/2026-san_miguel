package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/**
 * Descripción de un dibujo en una pantalla simulada.
 * El diagrama UML no define cómo representar gráficamente un dibujo.
 */
public class Dibujo {
    private final String tipo;
    private final int x;
    private final int y;
    private final String descripcion;

    public Dibujo(String tipo, int x, int y, String descripcion) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.descripcion = descripcion;
    }

    public String obtenerTipo() { return tipo; }
    public int obtenerX() { return x; }
    public int obtenerY() { return y; }
    public String obtenerDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return tipo + " en (" + x + ", " + y + "): " + descripcion;
    }
}
