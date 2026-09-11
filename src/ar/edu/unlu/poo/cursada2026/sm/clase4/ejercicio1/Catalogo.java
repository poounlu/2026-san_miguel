package ar.edu.unlu.poo.cursada2026.sm.clase4.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogo {
    private List<Artefacto> artefactos;

    public Catalogo() {
        this.artefactos = new ArrayList<>();
    }

    public void agregarArtefacto(Artefacto artefacto) {
        this.artefactos.add(artefacto);
    }

    public List<Artefacto> filtrarPorMarca(String marca) {
        return this.artefactos
                .stream()
                .filter(artefacto -> artefacto.getMarca().equals(marca))
                .toList();
    }

    public List<String> obtenerModelos(String marca) {
        return this.artefactos.stream()
                .filter(artefacto -> artefacto.getMarca().equals(marca))
                .map(artefacto -> artefacto.getModelo())
                .toList();
    }

    /*public Optional<Artefacto> buscarMasCaro(String artefacto) {
    }*/
}
