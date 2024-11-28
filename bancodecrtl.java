package controller;

import model.Conta;
import model.Funcionario;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import utils.DataManager;

public class BancoController {
    private List<Conta> contas;
    private List<Funcionario> funcionarios;

    // Construtor que carrega os dados ao iniciar a aplicação
    public BancoController() {
        contas = new ArrayList<>();
        funcionarios = new ArrayList<>();
        carregarDados();
    }

    // Abre uma nova conta, verificando se a conta já existe
    public void abrirConta(Conta conta) {
        // Verifica se a conta já está na lista
        if (consultarConta(conta.getNumero()).isPresent()) {
            System.out.println("Erro: Conta já existe.");
        } else {
            contas.add(conta);
            salvarDados();
        }
    }

    // Encerra uma conta existente pelo número
    public void encerrarConta(int numeroConta) {
        boolean contaRemovida = contas.removeIf(conta -> conta.getNumero() == numeroConta);
        if (contaRemovida) {
            salvarDados();
        } else {
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    // Consulta uma conta e retorna um Optional
    public Optional<Conta> consultarConta(int numeroConta) {
        return contas.stream()
                     .filter(c -> c.getNumero() == numeroConta)
                     .findFirst();
    }

    // Salva as informações das contas e dos funcionários
    public void salvarDados() {
        try {
            DataManager.salvarContas(contas, "contas.dat");
            DataManager.salvarFuncionarios(funcionarios, "funcionarios.dat");
        } catch (Exception e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Carrega os dados dos arquivos
    public void carregarDados() {
        try {
            contas = DataManager.carregarContas("contas.dat");
            funcionarios = DataManager.carregarFuncionarios("funcionarios.dat");
        } catch (Exception e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }

    // Métodos adicionais para gerenciamento de funcionários, caso necessário

    // Adiciona um novo funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarDados();
    }

    // Remove um funcionário pelo ID
    public void removerFuncionario(int idFuncionario) {
        funcionarios.removeIf(f -> f.getId() == idFuncionario);
        salvarDados();
    }
}
