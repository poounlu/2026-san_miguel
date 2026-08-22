package ar.edu.unlu.poo.cursada2026.sm.clase1.ejercicio01;

public class Motor {
    private double cilindrada;
    private double factorEficiencia;

    public Motor(double cilindrada, double factorEficiencia) {
        this.cilindrada = cilindrada;
        this.factorEficiencia = factorEficiencia;
    }

    /**

     * Estima el consumo de combustible en litros para los
     kilómetros indicados.
     * Encapsula la fórmula matemática dentro de la clase dueña
     de los datos.
     */
    public double calcularConsumo(double km){
        return (this.cilindrada * 0.05 + this.factorEficiencia) * km/100;
    }
}
