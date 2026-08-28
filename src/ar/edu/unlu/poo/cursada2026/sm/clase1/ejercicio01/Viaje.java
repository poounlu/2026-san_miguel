package ar.edu.unlu.poo.cursada2026.sm.clase1.ejercicio01;

public class Viaje {
    private double km;
    private Motor motor;

    public Viaje(double km, Motor motor) {
        this.km = km;
        this.motor = motor;
    }

    /**
     * Calcula el combustible necesario para el viaje.
     * Delega a Motor el cálculo en lugar de pedir cilindrada y
     factorEficiencia.
     */
    public double calcularCombustibleNecesario() {
        return this.motor.calcularConsumo(this.km);
    }

//    public static double calcularNafta () {
//        return motor.calcularConsumo(motor.km);
//    }

}