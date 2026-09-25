package ar.edu.unlu.poo.cursada2026.sm.clase6.ejercicio1;

public class Prenda {
    private double precioDeLista;

    public Prenda(double precioDeLista) {
        this.precioDeLista = precioDeLista;
    }

    public double getPrecioDeLista() {
        return precioDeLista;
    }

    public double calcularPrecio() {
        // Por defecto, se suma un 10% de ganancias
        return getPrecioDeLista() * 1.10;
    }

    // Sobrecarga (Polimorfismo ad hoc) para procesar el pago con tarjeta
    public double calcularPrecio(Tarjeta tarjeta) {
        double precioFinal = this.calcularPrecio();
        return tarjeta.aplicarDescuento(precioFinal);
    }
}
