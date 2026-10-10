package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

import java.util.Objects;

/**
 * Un conjunto contiene exactamente dos prendas: una Remera y otra Prenda.
 * La segunda prenda también puede ser otra Remera.
 * No se puede instanciar directamente: cada subtipo calcula su propio precio.
 */
public abstract class Conjunto implements Vendible {
    private final Remera remera;
    private final Prenda prenda;

    public Conjunto(Remera remera, Prenda prenda) {
        this.remera = Objects.requireNonNull(remera, "Debe incluir una remera");
        this.prenda = Objects.requireNonNull(prenda, "Debe incluir otra prenda");
    }

    public Remera getRemera() {
        return remera;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    @Override
    public abstract double calcularPrecio();

    @Override
    public abstract double calcularPrecio(Tarjeta tarjeta);
}
