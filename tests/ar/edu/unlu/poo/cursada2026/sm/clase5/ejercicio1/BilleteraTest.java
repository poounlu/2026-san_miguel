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
}
