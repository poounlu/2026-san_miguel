package ar.edu.unlu.poo.cursada2026.sm.clase5.ejercicio1;

public class Cuenta {
    private String divisa;
    private double saldo;

    public Cuenta(String divisa){
        this.divisa = divisa;
        this.saldo = 0.0;
    }


    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double monto) {
        if(monto <= 0){
            throw new IllegalArgumentException("El monto NO puede ser negativo o cero: " + monto);
        }
        this.saldo += monto;
    }

    public void extraer(double monto) {
        if(monto <= 0) {
            throw new IllegalArgumentException("El monto NO puede ser negativo o cero: " + monto);
        }
        if((this.saldo - monto) < 0){
            throw new SaldoInsuficienteException("El saldo es insuficiente");
        }
        this.saldo = this.saldo - monto;
    }
}
