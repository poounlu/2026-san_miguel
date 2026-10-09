package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Verificaciones sencillas ejecutables sin JUnit ni bibliotecas adicionales. */
public class Pruebas {
    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }

    public static void main(String[] argumentos) {
        Circulo circulo = new Circulo("Disco", 5, 10, 10);
        Rectangulo rectangulo = new Rectangulo("Puerta", 4, 6, 0, 0);
        Auto auto = new Auto(3, "azul", 40, 10);
        Casa casa = new Casa("Belgrano 9", 2, 30, 15);

        verificar(Math.abs(circulo.calcularArea() - Math.PI * 25) < 0.0001,
                "área del círculo");
        verificar(rectangulo.calcularArea() == 24, "área del rectángulo");
        verificar(circulo.estaEn(12, 12), "punto interior del círculo");
        verificar(!circulo.estaEn(50, 50), "punto exterior del círculo");
        verificar(rectangulo.estaEn(3, 5), "punto interior del rectángulo");
        verificar(!rectangulo.estaEn(4, 6), "punto exterior del rectángulo");
        verificar(auto.estaEn(40, 10) && !auto.estaEn(39, 10), "posición del auto");
        verificar(casa.estaEn(30, 15), "posición de la casa");

        Lienzo lienzo = new Lienzo();
        AdministradorDibujos administrador = new AdministradorDibujos(lienzo);
        administrador.agregar(circulo);
        administrador.agregar(rectangulo);
        administrador.agregar(auto);
        administrador.agregar(casa);

        verificar(lienzo.obtenerDibujos().size() == 4, "cantidad inicial de dibujos");
        verificar(administrador.seleccionar(12, 12) == circulo,
                "selección mediante un punto del círculo");
        administrador.mover(100, 200);
        verificar(circulo.obtenerX() == 100 && circulo.obtenerY() == 200,
                "movimiento del círculo");
        verificar(lienzo.obtenerDibujos().size() == 4, "redibujado sin duplicados");
        verificar(administrador.seleccionar(12, 12) == null,
                "la posición anterior ya no selecciona al círculo");
        verificar(administrador.seleccionar(100, 200) == circulo,
                "selección posterior al movimiento");
        verificar(administrador.seleccionar(40, 10) == auto, "selección del auto");
        administrador.mover(45, 12);
        verificar(auto.obtenerX() == 45 && auto.obtenerY() == 12,
                "movimiento del auto");
        System.out.println("Todas las verificaciones pasaron correctamente.");
    }
}
