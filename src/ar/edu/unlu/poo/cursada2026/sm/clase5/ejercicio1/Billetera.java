package ar.edu.unlu.poo.cursada2026.sm.clase5.ejercicio1;

import java.util.HashMap;
import java.util.Map;

public class Billetera {
    private Map<String, Cuenta> cuentas;

    public Billetera (){
        cuentas = new HashMap<>();
    }

    void abrirCuenta(String divisa){
        if(this.cuentas.containsKey(divisa)){
            throw new CuentaDuplicadaException("La divisa ya existe:" + divisa);
        }
        String divisaNormalizada = divisa.trim().toUpperCase();
        this.cuentas.put(divisaNormalizada, new Cuenta(divisaNormalizada));
    }

    double getSaldo(String moneda){
        return this.cuentas.get(moneda).getSaldo();
    }

    public void depositar(String divisa, double monto) {
        if(!this.cuentas.containsKey(divisa)){
            throw new RuntimeException("La divisa no existe: " + divisa);
        }
        this.cuentas.get(divisa).depositar(monto);
    }

    public void extraer(String divisa, double monto) {
        if(!this.cuentas.containsKey(divisa)){
            throw new RuntimeException("La divisa no existe: " + divisa);
        }
        this.cuentas.get(divisa).extraer(monto);
    }
}
