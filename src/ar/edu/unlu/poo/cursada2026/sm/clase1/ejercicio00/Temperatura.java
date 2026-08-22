package ar.edu.unlu.poo.cursada2026.sm.clase1.ejercicio00;

public class Temperatura {
    private double celsius;

    public Temperatura(double celsius) {
        if(celsius < -273.15) {
            throw new RuntimeException("No se puede crear una Temperatura menor a -273.15 ");
        }
        this.celsius = celsius;
    }

    public double getCelsius() {
        return this.celsius;
    }

    public double aFarenheit() {
        return this.celsius * 1.8 + 32;
    }

    @Override
    public String toString() {
        return "Temperatura {" +
                "celsius=" + celsius +
                '}';
    }
}
