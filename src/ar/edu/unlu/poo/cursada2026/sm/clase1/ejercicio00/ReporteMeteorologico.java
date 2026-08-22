package ar.edu.unlu.poo.cursada2026.sm.clase1.ejercicio00;

public class ReporteMeteorologico {
    private String ciudad;
    private Temperatura temperatura;

    public ReporteMeteorologico(String ciudad, Temperatura temperatura) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "ReporteMeteorologico{" +
                "ciudad='" + ciudad + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }
}
