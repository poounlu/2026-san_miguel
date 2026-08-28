package ar.edu.unlu.poo.cursada2026.sm.clase1.ejercicio01;

public class Main {
    public static void main(String[] args) {
        Motor motor = new Motor(2, 0.9);
        Viaje viaje = new Viaje (200, motor);

        double combustibleNecesario = viaje.calcularCombustibleNecesario();
        System.out.println(combustibleNecesario);

        double nafta = Viaje.calcularNafta();

        // objeto.method -> method de instancia
        // clase.methdo -> method de clase - static
    }
}