package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Una casa NO es una figura geométrica, pero SÍ es dibujable. */
public class Casa implements Dibujable {
    private final String direccion;
    private final int cantidadHabitaciones;
    private int x;
    private int y;

    public Casa(String direccion, int cantidadHabitaciones, int x, int y) {
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("Se requiere una dirección");
        }
        if (cantidadHabitaciones < 0) {
            throw new IllegalArgumentException("La cantidad de habitaciones no puede ser negativa");
        }
        this.direccion = direccion;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.x = x;
        this.y = y;
    }

    public String obtenerDireccion() { return direccion; }

    public int obtenerCantidadHabitaciones() { return cantidadHabitaciones; }

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
        return new Dibujo("Casa", x, y,
                "dirección=" + direccion + ", habitaciones=" + cantidadHabitaciones);
    }

    /** Simplificación: la casa se selecciona en su coordenada de referencia. */
    @Override
    public boolean estaEn(int x, int y) {
        return this.x == x && this.y == y;
    }
}
