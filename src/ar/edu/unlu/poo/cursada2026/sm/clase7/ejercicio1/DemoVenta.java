package ar.edu.unlu.poo.cursada2026.sm.clase7.ejercicio1;

public class DemoVenta {
    public static void main(String[] args) {
        Remera remera = new Remera(1000);       // (1000 + 100) * 1.10 = 1210
        Camisa camisa = new Camisa(2000, true); // 2000 * (1.10 + 0.05) = 2300
        Sweater sweater = new Sweater(3000);    // 3000 * 1.08 = 3240

        Conjunto c1 = new ConjuntoConDescuento(remera, camisa, 10); // 3159
        Conjunto c2 = new ConjuntoDosPorUno(new Remera(800), sweater); // 3240

        Venta venta = new Venta();
        venta.agregarPrenda(new Camisa(1500, false)); // 1650
        venta.agregarConjunto(c1);
        venta.agregarVendible(c2); // también acepta conjuntos, por la interfaz

        System.out.println("PRECIOS DE LOS VENDIBLES:");
        for (String renglon : venta.listarPrecios()) {
            System.out.println("  " + renglon);
        }
        System.out.printf( "TOTAL SIN TARJETA: $%.2f%n", venta.calcularTotal());
        System.out.printf("TOTAL TARJETA: $%.2f%n", venta.calcularTotal(new Tarjeta()));
        System.out.printf( "TOTAL TARJETA DORADA: $%.2f%n", venta.calcularTotal(new TarjetaDorada()));
    }
}
