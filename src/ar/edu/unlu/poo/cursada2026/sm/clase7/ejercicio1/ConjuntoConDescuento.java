package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

import java.util.Objects;

/** Se suman los precios de ambas prendas y se descuenta un porcentaje. */
public class ConjuntoConDescuento extends Conjunto {
    private final double porcentajeDescuento;

    /** Por ejemplo: 10 significa un descuento del 10 %. */
    public ConjuntoConDescuento(Remera remera, Prenda prenda, double porcentajeDescuento) {
        super(remera, prenda);
        if (!Double.isFinite(porcentajeDescuento)
                || porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public double calcularPrecio() {
        double suma = getRemera().calcularPrecio() + getPrenda().calcularPrecio();
        return suma * (1 - porcentajeDescuento / 100);
    }

    @Override
    public double calcularPrecio(Tarjeta tarjeta) {
        Objects.requireNonNull(tarjeta, "La tarjeta es obligatoria");
        // Primero la promoción del conjunto; después, el descuento de tarjeta.
        return tarjeta.aplicarDescuento(calcularPrecio());
    }
}
