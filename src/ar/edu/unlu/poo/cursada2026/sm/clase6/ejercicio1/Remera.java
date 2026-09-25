package ar.edu.unlu.poo.cursada2026.sm.clase6.ejercicio1;

public class Remera extends Prenda {

    public Remera(double precioDeLista) {
        super(precioDeLista);
    }

    @Override
    public double getPrecioDeLista() {
        // Se adosa un impuesto de $100 sobre el precio de lista
        return super.getPrecioDeLista() + 100.0;
    }
}
