package ar.edu.unlu.poo.cursada2026.sm.clase8.v1;

/**
 * Abstracción genérica de un código postal.
 * Mantiene su representación textual y delega la validación.
 */
public class CodigoPostal {

    protected String codigo;
    private ValidadorCodigoPostal validador;

    public CodigoPostal(String codigo, ValidadorCodigoPostal validador) {
        this.codigo = codigo;
        this.validador = validador;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public ValidadorCodigoPostal getValidador() {
        return this.validador;
    }

    public void setValidador(ValidadorCodigoPostal validador) {
        this.validador = validador;
    }

    /**
     * Delega la validación a la estrategia configurada y le pasa this.
     */
    public boolean esValido() {
        if (this.validador == null) {
            return false;
        }
        return this.validador.validar(this);
    }
}
