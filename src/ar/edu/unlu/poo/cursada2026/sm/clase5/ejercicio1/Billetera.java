package ar.edu.unlu.poo.cursada2026.sm.clase5.ejercicio1;

import java.util.HashMap;
import java.util.Map;

public class Billetera {
    private Map<String, Cuenta> cuentas;

    public Billetera (){
        cuentas = new HashMap<>();
    }

    void abrirCuenta(String moneda){

    }

    double getSaldo(String moneda){
        return 0.0;
    }
}
