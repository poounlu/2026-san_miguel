package ar.edu.unlu.poo.cursada2026.sm.clase8.v2;

/**
 * Especialización de CodigoPostal para la República Argentina.
 */
public class CodigoPostalArgentino extends CodigoPostal {

    public CodigoPostalArgentino(String codigo, ValidadorCodigoPostal validador) {
        super(codigo, validador);
    }

    public CodigoPostalArgentino(String codigo) {
        super(codigo, new ValidadorCodigoPostalArgentino());
    }
}
