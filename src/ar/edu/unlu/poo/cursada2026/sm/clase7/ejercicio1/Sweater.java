package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

public class Sweater extends Prenda {

    public Sweater(double precioDeLista) {
        super(precioDeLista);
    }

    @Override
    public double calcularPrecio() {
        // Solo se les adiciona un 8% de ganancias sobre el precio de lista
        return getPrecioDeLista() * 1.08;
    }
}
