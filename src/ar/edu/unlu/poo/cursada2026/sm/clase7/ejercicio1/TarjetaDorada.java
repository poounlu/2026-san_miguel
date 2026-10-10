package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

public class TarjetaDorada extends Tarjeta {
    @Override
    public double aplicarDescuento(double monto) {
        // Descuento del 1.5% más un plus de $100
        return monto - (monto * 0.015) - 100.0;
    }
}
