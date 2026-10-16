package ar.edu.unlu.poo.cursada2026.sm.clase8.v2;

/**
 * Valida los formatos argentinos: tradicional de 4 dígitos
 * y CPA de 1 letra, 4 números y 3 letras.
 */
public class ValidadorCodigoPostalArgentino implements ValidadorCodigoPostal {

    private final String formatoViejoRegex = "^\\d{4}$";
    private final String formatoNuevoRegex = "^[A-Za-z]\\d{4}[A-Za-z]{3}$";

    public String getFormatoViejoRegex() {
        return this.formatoViejoRegex;
    }

    public String getFormatoNuevoRegex() {
        return this.formatoNuevoRegex;
    }

    @Override
    public boolean validar(CodigoPostal cp) {
        if (cp == null || cp.getCodigo() == null) {
            return false;
        }

        String texto = cp.getCodigo().trim();
        return texto.matches(this.formatoViejoRegex)
                || texto.matches(this.formatoNuevoRegex);
    }
}
