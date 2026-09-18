package ar.edu.unlu.poo.cursada2026.sm.clase5.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BilleteraTest {

    private Billetera billetera;
    @BeforeEach
    public void setUp() {
        billetera = new Billetera();
    }

    @Test
    //RED
    //GREEN
    void testAperturaCuentaSaldoInicialCero(){
        billetera.abrirCuenta("ARS");
        assertEquals(0.0, billetera.getSaldo("ARS"), 0.0001);
    }

    @Test
    void testAperturaCuentaSaldoInicialCeroConEspaciosYLetrasMinusculas(){
        billetera.abrirCuenta("  ArS   ");
        assertEquals(0.0, billetera.getSaldo("ARS"), 0.0001);
    }

    @Test
    void testDivisaUnicaLanzaException(){
        billetera.abrirCuenta("ARS");
        assertThrows(CuentaDuplicadaException.class, () -> {
            billetera.abrirCuenta("ARS");
        });
    }

    @Test
    void testDepositoMontoNegativo(){
        billetera.abrirCuenta("ARS");
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.depositar("ARS", -1000.0);
        });
    }

    @Test
    void testDepositoMontoValido(){
        billetera.abrirCuenta("ARS");
        billetera.depositar("ARS", 1000.0);
        assertEquals(1000.0, billetera.getSaldo("ARS"), 0.0001);
    }

    @Test
    public void testExtraer_saldoInsuficiente_lanzaExcepcionYNoMutaSaldo() {
        billetera.abrirCuenta("ARS");
        billetera.depositar("ARS", 1000.0);
        assertThrows(SaldoInsuficienteException.class, () -> {
            billetera.extraer("ARS", 1500.0);
        });
        // Verificación de atomicidad: el saldo previo debe permanecer intacto
        assertEquals(1000.0, billetera.getSaldo("ARS"), 0.0001);
    }

    //TODO Tarea: Completar los siguientes Test:
    @Test
    void testExtraer_montoValido_decrementaSaldo() {
        billetera.abrirCuenta("ARS");
        billetera.depositar("ARS", 1000.0);
        billetera.extraer("ARS", 400.0);
        assertEquals(600.0, billetera.getSaldo("ARS"), 0.0001);
    }

    @Test
    void testExtraer_montoNegativoOCero_lanzaException() {
        billetera.abrirCuenta("ARS");
        billetera.depositar("ARS", 1000.0);
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.extraer("ARS", -500.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.extraer("ARS", 0.0);
        });
    }

    @Test
    void testAbrirCuenta_divisaNulaOVacida_lanzaException() {
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.abrirCuenta(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.abrirCuenta("");
        });
    }

    @Test
    void testOperarSobreDivisaInexistente_lanzaException() {
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.depositar("USD", 100.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.extraer("USD", 50.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.getSaldo("USD");
        });
    }

    //TODO Bloque Transferencia: descomentar y probar los Test, refactorizar
//    @Test
//    void testTransferir_fondosSuficientes_actualizaSaldos() {
//        Billetera destino = new Billetera();
//        billetera.abrirCuenta("ARS");
//        billetera.depositar("ARS", 1000.0);
//        destino.abrirCuenta("ARS");
//
//        Transferencia comprobante = billetera.transferir(destino, "ARS", 400.0);
//
//        assertEquals(600.0, billetera.getSaldo("ARS"), 0.0001);
//        assertEquals(400.0, destino.getSaldo("ARS"), 0.0001);
//        assertEquals(400.0, comprobante.getMonto());
//    }
//
//    @Test
//    void testTransferir_saldoInsuficiente_lanzaExceptionYNoMutaSaldos() {
//        Billetera destino = new Billetera();
//        billetera.abrirCuenta("ARS");
//        billetera.depositar("ARS", 200.0);
//        destino.abrirCuenta("ARS");
//        destino.depositar("ARS", 100.0);
//
//        assertThrows(SaldoInsuficienteException.class, () -> {
//            billetera.transferir(destino, "ARS", 500.0);
//        });
//
//        assertEquals(200.0, billetera.getSaldo("ARS"), 0.0001);
//        assertEquals(100.0, destino.getSaldo("ARS"), 0.0001);
//    }
//
//    @Test
//    void testTransferir_destinoSinCuenta_lanzaExceptionYNoMutaOrigen() {
//        Billetera destino = new Billetera();
//        billetera.abrirCuenta("ARS");
//        billetera.depositar("ARS", 1000.0);
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            billetera.transferir(destino, "ARS", 400.0);
//        });
//
//        // El saldo origen no debe descontarse si el destino falló
//        assertEquals(1000.0, billetera.getSaldo("ARS"), 0.0001);
//    }
//
//    @Test
//    void testTransferir_destinoInvalidoOMismoDestino_lanzaException() {
//        billetera.abrirCuenta("ARS");
//        billetera.depositar("ARS", 500.0);
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            billetera.transferir(null, "ARS", 100.0);
//        });
//        assertThrows(IllegalArgumentException.class, () -> {
//            billetera.transferir(billetera, "ARS", 100.0); // Transferir a sí mismo
//        });
//    }
}
