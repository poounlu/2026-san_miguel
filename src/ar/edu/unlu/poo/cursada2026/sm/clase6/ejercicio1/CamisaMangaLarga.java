package ar.edu.unlu.poo.cursada2026.sm.clase6.ejercicio1;

public class CamisaMangaLarga extends Camisa{
    public CamisaMangaLarga(double precioDeLista) {
        super(precioDeLista);
    }
    @Override
    public double calcularPrecio() {
        return super.calcularPrecio() * 1.15;
    }
}
