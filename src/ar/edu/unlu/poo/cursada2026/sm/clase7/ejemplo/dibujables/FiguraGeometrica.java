package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Clase abstracta que reúne lo común a las figuras geométricas. */
public abstract class FiguraGeometrica {
    private final String nombre;

    protected FiguraGeometrica(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }

    /** Cada figura concreta debe proporcionar su fórmula de área. */
    public abstract double calcularArea();
}
