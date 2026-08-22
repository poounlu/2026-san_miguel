package ar.edu.unlu.poo.cursada2026.sm.clase1.ejercicio00;

public class Main {
    public static void main(String[] args) {
        Temperatura t = new Temperatura(10);
        ReporteMeteorologico reporte1 = new ReporteMeteorologico("Bs As", t);
        ReporteMeteorologico reporte2 = new ReporteMeteorologico("La Pampa", new Temperatura(-10));
        System.out.println(reporte1.toString());
    }
}
