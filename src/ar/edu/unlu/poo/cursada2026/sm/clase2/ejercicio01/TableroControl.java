package ar.edu.unlu.poo.cursada2026.sm.clase2.ejercicio01;

import java.util.ArrayList;

public class TableroControl {
    private String nombrePlanta;
    private ArrayList <Reactor> reactores;

    public TableroControl(String nombrePlanta){
        this.nombrePlanta = nombrePlanta;
        this.reactores = new ArrayList<>();
    }

    public void agregarReactor (Reactor reactor){
        if (reactor == null)
            throw new IllegalArgumentException("El reactor no puede ser nulo");

        this.reactores.add(reactor);
    }

    public ArrayList<Reactor> getReactores(){
        return this.reactores;
    }

    @Override
    public String toString() {
        return "TableroControl{" +
                "nombrePlanta='" + nombrePlanta + '\'' +
                ", reactores=" + reactores +
                '}';
    }
}
