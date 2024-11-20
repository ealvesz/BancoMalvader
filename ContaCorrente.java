package model;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, double limite) {
        super(numero);
        this.tipoConta = "Corrente";
        this.limite = limite;
    }

    public boolean verificarLimite(double valor) {
        return (valor <= (saldo + limite));
    }

    // Getter and Setter for limite
    public double getLimite() { return limite; }
    public void setLimite(double limite) { this.limite = limite; }
}
