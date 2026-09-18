package ar.edu.unlu.poo.cursada2026.sm.clase5.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BilleteraTest {

    @Test
    //RED
    //GREEN
    void testAperturaCuentaSaldoInicialCero(){
        Billetera billetera = new Billetera();
        billetera.abrirCuenta("ARS");
        assertEquals(0.0, billetera.getSaldo("ARS"), 0.0001);
    }

    @Test
    void testAperturaCuentaSaldoInicialCeroConEspaciosYLetrasMinusculas(){
        Billetera billetera = new Billetera();
        billetera.abrirCuenta("  ArS   ");
        assertEquals(0.0, billetera.getSaldo("ARS"), 0.0001);
    }

    @Test
    void testDivisaUnicaLanzaException(){
        Billetera billetera = new Billetera();
        billetera.abrirCuenta("ARS");
        assertThrows(CuentaDuplicadaException.class, () -> {
            billetera.abrirCuenta("ARS");
        });
    }

    @Test
    void testDepositoMontoNegativo(){
        Billetera billetera = new Billetera();
        billetera.abrirCuenta("ARS");
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.depositar("ARS", -1000.0);
        });
    }

    @Test
    void testDepositoMontoValido(){
        Billetera billetera = new Billetera();
        billetera.abrirCuenta("ARS");
        billetera.depositar("ARS", 1000.0);
        assertEquals(1000.0, billetera.getSaldo("ARS"), 0.0001);
    }

    @Test
    public void testExtraer_saldoInsuficiente_lanzaExcepcionYNoMutaSaldo() {
        Billetera billetera = new Billetera();
        billetera.abrirCuenta("ARS");
        billetera.depositar("ARS", 1000.0);
        assertThrows(SaldoInsuficienteException.class, () -> {
            billetera.extraer("ARS", 1500.0);
        });
        // Verificación de atomicidad: el saldo previo debe permanecer intacto
        assertEquals(1000.0, billetera.getSaldo("ARS"), 0.0001);
    }
}
