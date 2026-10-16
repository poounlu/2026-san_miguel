package ar.edu.unlu.poo.cursada2026.sm.clase8.ejercicio1.v2;

import ar.edu.unlu.poo.cursada2026.sm.clase8.v2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Batería de Pruebas: Validación de Códigos Postales y Enrutador de Envíos")
public class CodigoPostalTest {
    private EnrutadorEnvios enrutador;
    private ValidadorCodigoPostalArgentino validadorArg;
    private ValidadorZipCodeUsa validadorUsa;

    @BeforeEach
    public void setUp() {
        enrutador = new EnrutadorEnvios();
        validadorArg = new ValidadorCodigoPostalArgentino();
        validadorUsa = new ValidadorZipCodeUsa();
    }

    @Test
    @DisplayName("Debe validar exitosamente códigos postales argentinos tradicionales de 1974 (4 dígitos)")
    public void testCodigoPostalArgentinoTradicionalValido() {
        CodigoPostal cpLujan = new CodigoPostalArgentino("6700", validadorArg);
        CodigoPostal cpMercedes = new CodigoPostalArgentino("6600", validadorArg);
        CodigoPostal cpPatagoniaConCero = new CodigoPostalArgentino("0340", validadorArg);
        assertTrue(cpLujan.esValido(), "El código 6700 debe ser válido bajo formato 1974");
        assertTrue(cpMercedes.esValido(), "El código 6600 debe ser válido bajo formato 1974");
        assertTrue(cpPatagoniaConCero.esValido(), "El código 0340 con cero inicial debe ser válido bajo formato 1974");
    }

    @Test
    @DisplayName("Debe validar exitosamente códigos CPA argentinos modernos de 1998 (1 letra + 4 dígitos + 3 letras)")
    public void testCodigoPostalArgentinoModernoCpaValido() {
        CodigoPostal cpBuenosAires = new CodigoPostalArgentino("B1636FDA", validadorArg);
        CodigoPostal cpCapitalFederal = new CodigoPostalArgentino("C1024CWN", validadorArg);
        CodigoPostal cpMinusculas = new CodigoPostalArgentino("b1636fda", validadorArg);
        assertTrue(cpBuenosAires.esValido(), "El CPA B1636FDA debe ser aceptado");
        assertTrue(cpCapitalFederal.esValido(), "El CPA C1024CWN debe ser aceptado");
        assertTrue(cpMinusculas.esValido(), "El CPA en letras minúsculas debe ser aceptado insensible a mayúsculas");
    }

    @Test
    @DisplayName("Debe rechazar códigos postales argentinos con formatos inválidos")
    public void testCodigoPostalArgentinoFormatosInvalidos() {
        CodigoPostal cpMuyCorto = new CodigoPostalArgentino("670", validadorArg);
        CodigoPostal cpCincoDigitos = new CodigoPostalArgentino("12345", validadorArg);
        CodigoPostal cpAlfanumericoIncompleto = new CodigoPostalArgentino("B1636FD", validadorArg);
        CodigoPostal cpConSimbolos = new CodigoPostalArgentino("XX-9900", validadorArg);
        CodigoPostal cpVacio = new CodigoPostalArgentino("", validadorArg);
        CodigoPostal cpNulo = new CodigoPostalArgentino(null, validadorArg);
        assertFalse(cpMuyCorto.esValido(), "Código de 3 dígitos debe ser rechazado");
        assertFalse(cpCincoDigitos.esValido(), "Código de 5 dígitos no corresponde al formato argentino");
        assertFalse(cpAlfanumericoIncompleto.esValido(), "CPA con solo 2 letras finales debe ser rechazado");
        assertFalse(cpConSimbolos.esValido(), "Código con guiones y símbolos debe ser rechazado");
        assertFalse(cpVacio.esValido(), "Código vacío debe ser rechazado");
        assertFalse(cpNulo.esValido(), "Código con valor nulo debe ser rechazado");
    }

    @Test
    @DisplayName("Debe validar exitosamente ZIP Codes estadounidenses estándar (5 dígitos) y extendidos (ZIP+4)")
    public void testZipCodeUsaValidos() {
        CodigoPostal zipEstandar = new CodigoPostal("90210", validadorUsa) {};
        CodigoPostal zipExtendido = new CodigoPostal("12345-1234", validadorUsa) {};
        assertTrue(zipEstandar.esValido(), "ZIP Code de 5 dígitos 90210 debe ser válido");
        assertTrue(zipExtendido.esValido(), "ZIP Code extendido 12345-1234 debe ser válido");
    }

    @Test
    @DisplayName("Debe rechazar ZIP Codes estadounidenses con formato incorrecto")
    public void testZipCodeUsaInvalidos() {
        CodigoPostal zipCorto = new CodigoPostal("1234", validadorUsa) {};
        CodigoPostal zipLargoSinGuion = new CodigoPostal("123456", validadorUsa) {};
        CodigoPostal zipExtensionIncompleta = new CodigoPostal("12345-12", validadorUsa) {};
        CodigoPostal zipConLetras = new CodigoPostal("9021A", validadorUsa) {};
        assertFalse(zipCorto.esValido(), "ZIP de 4 dígitos debe ser rechazado");
        assertFalse(zipLargoSinGuion.esValido(), "ZIP de 6 dígitos sin guion debe ser rechazado");
        assertFalse(zipExtensionIncompleta.esValido(), "Extensión ZIP+4 con solo 2 dígitos debe ser rechazada");
        assertFalse(zipConLetras.esValido(), "ZIP estadounidense no admite letras");
    }

    @Test
    @DisplayName("El EnrutadorEnvios debe autorizar únicamente paquetes con códigos postales válidos")
    public void testEnrutadorEnviosDespacho() {
        CodigoPostal paqueteArgValido = new CodigoPostalArgentino("6700", validadorArg);
        CodigoPostal paqueteCpaValido = new CodigoPostalArgentino("B1636FDA", validadorArg);
        CodigoPostal paqueteArgInvalido = new CodigoPostalArgentino("INVALIDO", validadorArg);
        CodigoPostal paqueteUsaValido = new CodigoPostal("90210-4321", validadorUsa) {};
        CodigoPostal paqueteUsaInvalido = new CodigoPostal("123", validadorUsa) {};
        assertTrue(enrutador.enrutar(paqueteArgValido), "Debe enrutar paquete con código argentino tradicional válido");
        assertTrue(enrutador.enrutar(paqueteCpaValido), "Debe enrutar paquete con CPA moderno válido");
        assertTrue(enrutador.enrutar(paqueteUsaValido), "Debe enrutar paquete internacional con ZIP Code válido");
        assertFalse(enrutador.enrutar(paqueteArgInvalido), "Debe rechazar paquete con código argentino inválido");
        assertFalse(enrutador.enrutar(paqueteUsaInvalido), "Debe rechazar paquete internacional con ZIP inválido");
        assertFalse(enrutador.enrutar(null), "Debe rechazar enrutamiento cuando el código postal es nulo");
    }
    @Test
    @DisplayName("Debe permitir cambiar dinámicamente de estrategia de validación en tiempo de ejecución")
    public void testCambioDinamicoDeValidador() {
        CodigoPostal cp = new CodigoPostalArgentino("90210", validadorArg);
// Inicialmente con validador argentino: 90210 tiene 5dígitos, por lo que es inválido en Argentina
        assertFalse(cp.esValido(), "90210 no es un código argentino válido");
// Cambiamos la estrategia al validador de EE.UU cp.setValidador(validadorUsa);
        cp.setValidador(validadorUsa);
        assertTrue(cp.esValido(), "90210 debe ser válido al aplicar la estrategia estadounidense");
    }
}