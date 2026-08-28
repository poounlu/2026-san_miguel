package ar.edu.unlu.poo.cursada2026.sm.clase2.ejercicio01;

public class Main {

    public static void main(String[] args) {
        TableroControl tablero = new TableroControl("Tablero 1");
        tablero.agregarReactor(new Reactor("cod-001", 200.0));
        tablero.agregarReactor(new Reactor("cod-002", 250.0));
        Reactor r3 = new Reactor("cod-003", 270.0);
        try {
            tablero.agregarReactor(r3);
            r3.actualizarTemperatura(350.0);
        }
        catch (TemperaturaCriticaException ex){
            System.out.println(r3.estaEnAlerta());
        }

        System.out.println(tablero);


    }
}
