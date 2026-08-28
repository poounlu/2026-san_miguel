package ar.edu.unlu.poo.cursada2026.sm.clase2.ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class ClinicaVeterinaria {
    private String nombre;
    private List<Mascota> mascotasRegistradas;
    private List<ConsultaMedica> historialConsultas;

    public ClinicaVeterinaria(String nombre) {
        this.nombre = nombre;
        this.mascotasRegistradas = new ArrayList<>();
        this.historialConsultas = new ArrayList<>();
    }

    public void registrarMascota(Mascota m) {
        if (m == null) {
            throw new IllegalArgumentException("La mascota no puede ser nula.");
        }
        this.mascotasRegistradas.add(m);
    }

    public ConsultaMedica registrarConsulta(Mascota m, Veterinario v, String diagnostico, double costo) {
        if (m == null || v == null) {
            throw new IllegalArgumentException("La mascota y el veterinario no pueden ser nulos.");
        }

        if (this.mascotasRegistradas.contains(m) == false) {
            throw new MascotaNoEncontradaException("La mascota " + m.getNombre() + " no está registrada en la clínica.");
        }
        ConsultaMedica consulta = new ConsultaMedica(m, v, diagnostico, costo);
        this.historialConsultas.add(consulta);
        return consulta;
    }

    public List<ConsultaMedica> getConsultasPorMascota(String chip) {
        List<ConsultaMedica> resultado = new ArrayList<>();
        for (ConsultaMedica c : this.historialConsultas) {
            if (c.getMascota().getChip().equals(chip)) {
                resultado.add(c);
            }
        }
        return resultado;
//        return Collections.unmodifiableList(resultado); Falto explicar explicar
    }
}
