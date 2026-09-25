package ar.edu.unlu.poo.cursada2026.sm.clase6.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private List<Prenda> prendas;

    public Venta() {
        this.prendas = new ArrayList<>();
    }

    public void agregarPrenda(Prenda p) {
        this.prendas.add(p);
    }

    // Cálculo polimórfico del total sin tarjeta
    public double calcularTotal() {
        double total = 0.0;
        for (Prenda p : this.prendas) {
            total += p.calcularPrecio();
        }
        return total;
    }

    // Cálculo polimórfico del total aplicando un medio de pago a la venta
    public double calcularTotal(Tarjeta tarjeta) {
        double total = 0.0;
        for (Prenda p : this.prendas) {
            total += p.calcularPrecio(tarjeta);
        }
        return total;
    }
}
