package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Ahora la venta contiene Vendible, tanto prendas como conjuntos. */
public class Venta {
    private final List<Vendible> elementos;

    public Venta() {
        this.elementos = new ArrayList<>();
    }

    public void agregarVendible(Vendible vendible) {
        elementos.add(Objects.requireNonNull(vendible, "El vendible no puede ser nulo"));
    }

    // Se mantiene el método original de la clase 6.
    public void agregarPrenda(Prenda prenda) {
        agregarVendible(prenda);
    }

    public void agregarConjunto(Conjunto conjunto) {
        agregarVendible(conjunto);
    }

    public double calcularTotal() {
        return elementos.stream()
                .mapToDouble(Vendible::calcularPrecio)
                .sum();
    }

    public double calcularTotal(Tarjeta tarjeta) {
        Objects.requireNonNull(tarjeta, "La tarjeta es obligatoria");
        double total = 0;
        for (Vendible v : elementos) {
            total += v.calcularPrecio(tarjeta);
        }
        return total;
    }

    /** Lista los precios de todos los elementos a vender, incluidos los conjuntos. */
    public List<String> listarPrecios() {
        List<String> precios = new ArrayList<>();
        for (Vendible v : elementos) {
            precios.add(v.getClass().getSimpleName() + ": $" +
                    String.format(java.util.Locale.US, "%.2f", v.calcularPrecio()));
        }
        return precios;
    }
}
