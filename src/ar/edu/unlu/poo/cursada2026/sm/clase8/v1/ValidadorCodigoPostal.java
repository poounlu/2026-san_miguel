package ar.edu.unlu.poo.cursada2026.sm.clase8.v1;

/**
 * Contrato polimórfico para las estrategias de validación de códigos postales.
 * Permite separar las reglas de cada país de la clase CodigoPostal.
 */
public interface ValidadorCodigoPostal {

    /**
     * Valida si el código postal cumple con el formato de este validador.
     *
     * @param cp código postal a evaluar
     * @return true si cumple el formato; false en caso contrario
     */
    boolean validar(CodigoPostal cp);
}
