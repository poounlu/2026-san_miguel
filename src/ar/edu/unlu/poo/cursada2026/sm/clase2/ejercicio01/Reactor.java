package ar.edu.unlu.poo.cursada2026.sm.clase2.ejercicio01;

public class Reactor {
    // atributos del objeto
    private String codigo;
    private Double temperaturaActual;
    private boolean estadoAlerta;

    // atributos de la clase
    private static int totalAlertas = 0;
    private static double limiteTemperatura = 300.0;

    //constructor
    public Reactor (String codigo, Double temperatura){
        this.codigo = codigo;
        this.temperaturaActual = temperatura;
        this.estadoAlerta = false;
    }

    public void actualizarTemperatura(Double nuevaTemperatura){
        if (nuevaTemperatura == null){
            throw new IllegalArgumentException("La temperatura debe ser numerica");
        }

        this.temperaturaActual = nuevaTemperatura;

        if(nuevaTemperatura > limiteTemperatura){
            if(this.estadoAlerta == false){
                this.estadoAlerta = true;
                totalAlertas ++;
            }
            throw new TemperaturaCriticaException("ALERTA CRITICA - REACTOR " + this.codigo + "SUPERO LIMITE DE SEGURIDAD DE " + limiteTemperatura + "°C");
        }
    }

    public boolean estaEnAlerta(){
        return this.estadoAlerta;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public Double getTemperaturaActual(){
        return this.temperaturaActual;
    }

    //metodo de clase, comopartido por todos los objetos
    public static int getTotalAlertas(){
        return totalAlertas;
    }

    //metodo de clase, comopartido por todos los objetos
    public static void setLimiteTemperatura (Double limite){
        limiteTemperatura = limite;
    }

}

