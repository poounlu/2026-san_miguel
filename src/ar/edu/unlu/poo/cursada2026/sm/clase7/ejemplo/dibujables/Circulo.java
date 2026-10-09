package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Un círculo ES una figura geométrica y también ES dibujable. */
public class Circulo extends FiguraGeometrica implements Dibujable {
    private final double radio;
    private int x;
    private int y;

    public Circulo(String nombre, double radio, int x, int y) {
        super(nombre);
        if (radio <= 0 || !Double.isFinite(radio)) {
            throw new IllegalArgumentException("El radio debe ser positivo y finito");
        }
        this.radio = radio;
        this.x = x;
        this.y = y;
    }

    public double obtenerRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
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
        return new Dibujo("Círculo", x, y,
                "nombre=" + obtenerNombre() + ", radio=" + radio);
    }

    /** Las coordenadas del círculo representan su centro. */
    @Override
    public boolean estaEn(int x, int y) {
        double diferenciaX = (double) x - this.x;
        double diferenciaY = (double) y - this.y;
        return diferenciaX * diferenciaX + diferenciaY * diferenciaY <= radio * radio;
    }
}
