va (controle da aplicação, gerencia as operações das contas):

java
Copiar código
package controller;

import model.Conta;
import model.Funcionario;
import java.util.List;
import java.util.ArrayList;
import utils.DataManager;

public class BancoController {
    private List<Conta> contas;
    private List<Funcionario> funcionarios;

    public BancoController() {
        contas = new ArrayList<>();
        funcionarios = new ArrayList<>();
        carregarDados();
    }

    public void abrirConta(Conta conta) {
        contas.add(conta);
        salvarDados();
    }

    public void encerrarConta(int numeroConta) {
        contas.removeIf(conta -> conta.getNumero() == numeroConta);
        salvarDados();
    }

    public Conta consultarConta(int numeroConta) {
        return contas.stream().filter(c -> c.getNumero() == numeroConta).findFirst().orElse(null);
    }

    public void salvarDados() {
        DataManager.salvarContas(contas, "contas.dat");
        DataManager.salvarFuncionarios(funcionarios, "funcionarios.dat");
    }

    public void carregarDados() {
        contas = DataManager.carregarContas("contas.dat");
        funcionarios = DataManager.carregarFuncionarios("funcionarios.dat");
    }
}