package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VentaTest {

    private Venta venta;
    private Remera remera;
    private Camisa camisa;
    private Sweater sweater;
    private Conjunto conDescuento;
    private Conjunto dosPorUno;

    @BeforeEach
    public void setUp() {
        remera = new Remera(1000);
        camisa = new Camisa(2000, true);
        sweater = new Sweater(3000);

        conDescuento = new ConjuntoConDescuento(
                remera, camisa, 10);

        dosPorUno = new ConjuntoDosPorUno(
                new Remera(800), sweater);

        venta = new Venta();
        venta.agregarPrenda(new Camisa(1500, false));
        venta.agregarConjunto(conDescuento);
        venta.agregarVendible(dosPorUno);
    }

    // TEST 1: Precio de las prendas individuales
    @Test
    public void testCalcularPrecioPrendas() {
        assertEquals(1210, remera.calcularPrecio(), 0.000001);
        assertEquals(2300, camisa.calcularPrecio(), 0.000001);
        assertEquals(3240, sweater.calcularPrecio(), 0.000001);
    }

    // TEST 2: Conjunto con descuento
    @Test
    public void testConjuntoConDescuento() {
        assertEquals(3159, conDescuento.calcularPrecio(), 0.000001);
    }

    // TEST 3: Conjunto con descuento pagando con tarjeta
    @Test
    public void testConjuntoConDescuentoConTarjeta() {
        Tarjeta tarjeta = new Tarjeta();

        assertEquals(3127.41,
                conDescuento.calcularPrecio(tarjeta), 0.000001);
    }

    // TEST 4: Conjunto con descuento y tarjeta dorada
    @Test
    public void testConjuntoConDescuentoConTarjetaDorada() {
        TarjetaDorada tarjeta = new TarjetaDorada();

        assertEquals(3011.615,
                conDescuento.calcularPrecio(tarjeta), 0.000001);
    }

    // TEST 5: Conjunto 2x1
    @Test
    public void testConjuntoDosPorUno() {
        assertEquals(3240, dosPorUno.calcularPrecio(), 0.000001);
    }

    // TEST 6: Conjunto 2x1 con tarjeta
    @Test
    public void testConjuntoDosPorUnoConTarjeta() {
        Tarjeta tarjeta = new Tarjeta();

        assertEquals(3207.6,
                dosPorUno.calcularPrecio(tarjeta), 0.000001);
    }

    // TEST 7: Conjunto 2x1 con tarjeta dorada
    @Test
    public void testConjuntoDosPorUnoConTarjetaDorada() {
        TarjetaDorada tarjeta = new TarjetaDorada();

        assertEquals(3091.4,
                dosPorUno.calcularPrecio(tarjeta), 0.000001);
    }

    // TEST 8: Conjunto formado por dos remeras
    @Test
    public void testConjuntoDosRemeras() {
        Conjunto conjunto = new ConjuntoDosPorUno(
                new Remera(1000), new Remera(600));

        assertEquals(1210, conjunto.calcularPrecio(), 0.000001);
    }

    // TEST 9: Venta vacía
    @Test
    public void testVentaVacia() {
        Venta ventaVacia = new Venta();

        assertEquals(0, ventaVacia.calcularTotal(), 0.000001);
    }

    // TEST 10: Total de venta sin tarjeta
    @Test
    public void testCalcularTotalVenta() {
        assertEquals(8049, venta.calcularTotal(), 0.000001);
    }

    // TEST 11: Total de venta con tarjeta
    @Test
    public void testCalcularTotalConTarjeta() {
        Tarjeta tarjeta = new Tarjeta();

        assertEquals(7968.51,
                venta.calcularTotal(tarjeta), 0.000001);
    }

    // TEST 12: Total de venta con tarjeta dorada
    @Test
    public void testCalcularTotalConTarjetaDorada() {
        TarjetaDorada tarjeta = new TarjetaDorada();

        assertEquals(7628.265,
                venta.calcularTotal(tarjeta), 0.000001);
    }

    // TEST 13: Listado de elementos vendibles
    @Test
    public void testListarPrecios() {
        assertEquals(3, venta.listarPrecios().size());
    }

    // TEST 14: Validar porcentaje de descuento
    @Test
    public void testPorcentajeDescuentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ConjuntoConDescuento(
                    new Remera(100),
                    new Remera(100),
                    101);
        });
    }
}

