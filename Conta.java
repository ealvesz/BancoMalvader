package model;

public abstract class Conta {
    protected int numero;
    protected double saldo;
    protected String tipoConta;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    // Getters and Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public String getTipoConta() { return tipoConta; }
}