package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Un auto NO es una figura geométrica, pero SÍ es dibujable. */
public class Auto implements Dibujable {
    private final int grosorLinea;
    private final String color;
    private int x;
    private int y;

    public Auto(int grosorLinea, String color, int x, int y) {
        if (grosorLinea <= 0) {
            throw new IllegalArgumentException("El grosor de línea debe ser positivo");
        }
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Se requiere un color");
        }
        this.grosorLinea = grosorLinea;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int obtenerGrosorLinea() { return grosorLinea; }

    public String obtenerColor() { return color; }

    @Override
    public int obtenerX() { return x; }

    @Override
    public int obtenerY() { return y; }

    @Override
    public Dibujo moverA(int x, int y) {
        this.x = x;
        this.y = y;
        return dibujar();
    }

    @Override
    public Dibujo dibujar() {
        return new Dibujo("Auto", x, y,
                "color=" + color + ", grosor de línea=" + grosorLinea);
    }

    /** Simplificación: el auto se selecciona en su coordenada de referencia. */
    @Override
    public boolean estaEn(int x, int y) {
        return this.x == x && this.y == y;
    }
}
