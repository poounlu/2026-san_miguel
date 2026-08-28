package ar.edu.unlu.poo.cursada2026.sm.clase2.ejercicio02;

public class ConsultaMedica {

    private Mascota mascota;
    private Veterinario veterinario;
    private String diagnostico;
    private double costo;

    public ConsultaMedica(Mascota mascota, Veterinario veterinario, String diagnostico, double costo) {
        if (costo <= 0) {
            throw new CostoInvalidoException("El costo de la consulta debe ser mayor a cero.");
        }
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.diagnostico = diagnostico;
        this.costo = costo;
    }

    public Mascota getMascota() {
        return this.mascota;
    }
    public double getCosto() {
        return this.costo;
    }
}
