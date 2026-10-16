package ar.edu.unlu.poo.cursada2026.sm.clase8.v2;

/**
 * Valida los ZIP Codes estadounidenses: 5 dígitos o ZIP+4.
 */
public class ValidadorZipCodeUsa implements ValidadorCodigoPostal {

    private final String formatoZipRegex = "^\\d{5}(-\\d{4})?$";

    public String getFormatoZipRegex() {
        return this.formatoZipRegex;
    }

    @Override
    public boolean validar(CodigoPostal cp) {
        if (cp == null || cp.getCodigo() == null) {
            return false;
        }

        String texto = cp.getCodigo().trim();
        return texto.matches(this.formatoZipRegex);
    }
}
