package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

import java.util.Objects;

/** 2x1: se cobra la prenda de mayor precio final y la otra sale sin cargo. */
public class ConjuntoDosPorUno extends Conjunto {
    public ConjuntoDosPorUno(Remera remera, Prenda prenda) {
        super(remera, prenda);
    }

    @Override
    public double calcularPrecio() {
        return Math.max(getRemera().calcularPrecio(), getPrenda().calcularPrecio());
    }

    @Override
    public double calcularPrecio(Tarjeta tarjeta) {
        Objects.requireNonNull(tarjeta, "La tarjeta es obligatoria");
        // El descuento de la tarjeta se aplica una sola vez al conjunto.
        return tarjeta.aplicarDescuento(calcularPrecio());
    }
}
