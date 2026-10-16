package ar.edu.unlu.poo.cursada2026.sm.clase8.v1;

/**
 * Valida los ZIP Codes estadounidenses: 5 dígitos o ZIP+4.
 */

public class ValidadorZipCodeUsa
        implements ValidadorCodigoPostal {

    @Override
    public boolean validar(CodigoPostal cp) {

        if (cp == null || cp.getCodigo() == null) {
            return false;
        }

        String texto = cp.getCodigo().trim();

        // Debe tener 5 o 10 caracteres
        if (texto.length() != 5 &&
                texto.length() != 10) {
            return false;
        }

        // Los primeros 5 caracteres deben ser números
        for (int i = 0; i < 5; i++) {
            if (!esDigito(texto.charAt(i))) {
                return false;
            }
        }

        // ZIP tradicional de 5 dígitos
        if (texto.length() == 5) {
            return true;
        }

        // ZIP+4: debe tener un guion en la posición 5
        if (texto.charAt(5) != '-') {
            return false;
        }

        // Los últimos 4 caracteres deben ser números
        for (int i = 6; i < 10; i++) {
            if (!esDigito(texto.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean esDigito(char c) {
        return c >= '0' && c <= '9';
    }
}

