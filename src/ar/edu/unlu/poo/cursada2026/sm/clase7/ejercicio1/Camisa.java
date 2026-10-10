package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

public class Camisa extends Prenda {
    private boolean mangaLarga;

    public Camisa(double precioDeLista, boolean mangaLarga) {
        super(precioDeLista);
        this.mangaLarga = mangaLarga;
    }

    @Override
    public double calcularPrecio() {
        double precio = super.calcularPrecio();
        if (mangaLarga) {
            // Asigna un 5% extra de ganancias si es manga larga
            precio += getPrecioDeLista() * 0.05;
        }
        return precio;
    }
}
