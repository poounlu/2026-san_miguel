package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Ejemplo ejecutable para explicar clases abstractas, interfaces y polimorfismo. */
public class Demostracion {
    public static void main(String[] argumentos) {
        Circulo circulo = new Circulo("Sol", 5, 10, 10);
        Rectangulo rectangulo = new Rectangulo("Ventana", 8, 4, 0, 0);
        Auto auto = new Auto(2, "rojo", 40, 10);
        Casa casa = new Casa("San Martín 123", 3, 30, 15);

        // La clase abstracta permite trabajar con figuras concretas distintas.
        FiguraGeometrica figura1 = circulo;
        FiguraGeometrica figura2 = rectangulo;
        System.out.printf("Área de %s: %.2f%n", figura1.obtenerNombre(), figura1.calcularArea());
        System.out.printf("Área de %s: %.2f%n", figura2.obtenerNombre(), figura2.calcularArea());

        // La interfaz permite tratar de igual manera a figuras, autos y casas.
        Lienzo lienzo = new Lienzo();
        AdministradorDibujos administrador = new AdministradorDibujos(lienzo);
        administrador.agregar(circulo);
        administrador.agregar(rectangulo);
        administrador.agregar(auto);
        administrador.agregar(casa);
        lienzo.mostrar();

        // Seleccionamos un punto del círculo y movemos el objeto completo.
        Dibujable seleccionado = administrador.seleccionar(12, 11);
        if (seleccionado != null) {
            System.out.println("\nObjeto seleccionado: "
                    + seleccionado.dibujar().obtenerTipo());
            administrador.mover(20, 20);
        }
        lienzo.mostrar();

        // No necesitamos preguntar cuál es la clase concreta de cada objeto.
        System.out.println("\nPosiciones de todos los dibujables:");
        for (Dibujable objeto : new Dibujable[] {circulo, rectangulo, auto, casa}) {
            System.out.println(objeto.dibujar().obtenerTipo()
                    + ": (" + objeto.obtenerX() + ", " + objeto.obtenerY() + ")");
        }
    }
}
