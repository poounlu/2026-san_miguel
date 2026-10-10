package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

/** Contrato de todo elemento que se puede vender: prenda o conjunto. */
public interface Vendible {
    double calcularPrecio();
    double calcularPrecio(Tarjeta tarjeta);
}
