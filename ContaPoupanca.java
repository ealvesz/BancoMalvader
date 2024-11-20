package model;

public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(int numero, double taxaJuros) {
        super(numero);
        this.tipoConta = "Poupança";
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros() {
        saldo += saldo * taxaJuros;
    }

    // Getter and Setter for taxaJuros
    public double getTaxaJuros() { return taxaJuros; }
    public void setTaxaJuros(double taxaJuros) { this.taxaJuros = taxaJuros; }
}
