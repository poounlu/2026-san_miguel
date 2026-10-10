package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

/** Pruebas sin dependencias: se ejecutan con java -ea. */
public class VerificacionRapida {
    private static void verificar(double esperado, double actual) {
        if (Math.abs(esperado - actual) > 0.000001) {
            throw new AssertionError("Esperado " + esperado + ", obtenido " + actual);
        }
    }

    public static void main(String[] args) {
        Remera remera = new Remera(1000);
        Camisa camisa = new Camisa(2000, true);
        Sweater sweater = new Sweater(3000);
        verificar(1210, remera.calcularPrecio());
        verificar(2300, camisa.calcularPrecio());
        verificar(3240, sweater.calcularPrecio());

        Conjunto conDescuento = new ConjuntoConDescuento(remera, camisa, 10);
        verificar(3159, conDescuento.calcularPrecio());
        verificar(3127.41, conDescuento.calcularPrecio(new Tarjeta()));
        verificar(3011.615, conDescuento.calcularPrecio(new TarjetaDorada()));

        Conjunto dosPorUno = new ConjuntoDosPorUno(new Remera(800), sweater);
        verificar(3240, dosPorUno.calcularPrecio());
        verificar(3207.6, dosPorUno.calcularPrecio(new Tarjeta()));
        verificar(3091.4, dosPorUno.calcularPrecio(new TarjetaDorada()));

        Conjunto dosRemeras = new ConjuntoDosPorUno(new Remera(1000), new Remera(600));
        verificar(1210, dosRemeras.calcularPrecio());

        Venta venta = new Venta();
        venta.agregarPrenda(new Camisa(1500, false));
        venta.agregarConjunto(conDescuento);
        venta.agregarVendible(dosPorUno);
        verificar(8049, venta.calcularTotal());
        verificar(7968.51, venta.calcularTotal(new Tarjeta()));
        verificar(7628.265, venta.calcularTotal(new TarjetaDorada()));
        if (venta.listarPrecios().size() != 3) {
            throw new AssertionError("La venta debe listar prendas y conjuntos");
        }

        boolean porcentajeInvalido = false;
        try {
            new ConjuntoConDescuento(new Remera(100), new Remera(100), 101);
        } catch (IllegalArgumentException e) {
            porcentajeInvalido = true;
        }
        if (!porcentajeInvalido) throw new AssertionError("Falta validar el descuento");
        System.out.println("Todas las verificaciones pasaron correctamente.");
    }
}
