package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Un rectángulo ES una figura geométrica y también ES dibujable. */
public class Rectangulo extends FiguraGeometrica implements Dibujable {
    private final int ancho;
    private final int alto;
    private int x;
    private int y;

    public Rectangulo(String nombre, int ancho, int alto, int x, int y) {
        super(nombre);
        if (ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("El ancho y el alto deben ser positivos");
        }
        this.ancho = ancho;
        this.alto = alto;
        this.x = x;
        this.y = y;
    }

    public int obtenerAncho() { return ancho; }

    public int obtenerAlto() { return alto; }

    @Override
    public double calcularArea() {
        return (double) ancho * alto;
    }

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
        return new Dibujo("Rectángulo", x, y,
                "nombre=" + obtenerNombre() + ", ancho=" + ancho + ", alto=" + alto);
    }

    /** Las coordenadas del rectángulo representan su esquina superior izquierda. */
    @Override
    public boolean estaEn(int x, int y) {
        return x >= this.x && (long) x < (long) this.x + ancho
                && y >= this.y && (long) y < (long) this.y + alto;
    }
}
