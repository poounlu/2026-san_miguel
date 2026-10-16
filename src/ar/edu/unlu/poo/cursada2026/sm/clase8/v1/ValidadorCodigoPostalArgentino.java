package ar.edu.unlu.poo.cursada2026.sm.clase8.v1;

/**
 * Valida los formatos argentinos: tradicional de 4 dígitos
 * y CPA de 1 letra, 4 números y 3 letras.
 */

public class ValidadorCodigoPostalArgentino implements ValidadorCodigoPostal {

    @Override
    public boolean validar(CodigoPostal cp) {

        if (cp == null || cp.getCodigo() == null) {
            return false;
        }

        String texto = cp.getCodigo().trim();

        // Formato tradicional: 4 números
        if (texto.length() == 4) {

            for (int i = 0; i < 4; i++) {
                if (!esDigito(texto.charAt(i))) {
                    return false;
                }
            }

            return true;
        }

        // Formato moderno: 1 letra + 4 números + 3 letras
        if (texto.length() == 8) {

            // Primera posición: letra
            if (!esLetra(texto.charAt(0))) {
                return false;
            }

            // Posiciones 1 a 4: números
            for (int i = 1; i <= 4; i++) {
                if (!esDigito(texto.charAt(i))) {
                    return false;
                }
            }

            // Posiciones 5 a 7: letras
            for (int i = 5; i < 8; i++) {
                if (!esLetra(texto.charAt(i))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private boolean esDigito(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean esLetra(char c) {
        return (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z');
    }
}

