package ar.edu.unlu.poo.cursada2026.sm.clase8.v1;

/**
 * Autoriza o rechaza envíos utilizando la abstracción CodigoPostal.
 */
public class EnrutadorEnvios {

    /**
     * @return true si el código postal es no nulo y válido; false en otro caso.
     */
    public boolean enrutar(CodigoPostal cp) {
        if (cp == null || !cp.esValido()) {
            return false;
        }

        // Procede a confirmar el despacho en el sistema de distribución.
        return true;
    }
}
