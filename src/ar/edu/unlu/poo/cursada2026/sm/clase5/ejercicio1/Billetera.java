package ar.edu.unlu.poo.cursada2026.sm.clase5.ejercicio1;

import java.util.HashMap;
import java.util.Map;

public class Billetera {
    private Map<String, Cuenta> cuentas;

    public Billetera (){
        cuentas = new HashMap<>();
    }

    void abrirCuenta(String divisa){
        String divisaNormalizada = normalizarDivisa(divisa);
        if (this.cuentas.containsKey(divisaNormalizada)) {
            throw new CuentaDuplicadaException("Ya existe una cuenta para la divisa: " + divisaNormalizada);
        }
        this.cuentas.put(divisaNormalizada, new Cuenta(divisaNormalizada));
    }

    double getSaldo(String divisa){
        String divisaNormalizada = normalizarDivisa(divisa);
        if(!this.cuentas.containsKey(divisaNormalizada)){
            throw new RuntimeException("La divisa no existe: " + divisa);
        }
        return this.cuentas.get(divisaNormalizada).getSaldo();
    }

    public void depositar(String divisa, double monto) {
        String divisaNormalizada = normalizarDivisa(divisa);
        if(!this.cuentas.containsKey(divisaNormalizada)){
            throw new RuntimeException("La divisa no existe: " + divisa);
        }
        this.cuentas.get(divisa).depositar(monto);
    }

    public void extraer(String divisa, double monto) {
        String divisaNormalizada = normalizarDivisa(divisa);
        if(!this.cuentas.containsKey(divisaNormalizada)){
            throw new RuntimeException("La divisa no existe: " + divisa);
        }
        this.cuentas.get(divisa).extraer(monto);
    }

    private String normalizarDivisa(String divisa) {
        if (divisa == null || divisa.trim().isEmpty()) {
            throw new IllegalArgumentException("La divisa especificada es inválida.");
        }
        return divisa.trim().toUpperCase();
    }
}
