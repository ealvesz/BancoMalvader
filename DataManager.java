package utils;

import model.Conta;
import model.Funcionario;
import java.io.*;
import java.util.List;

public class DataManager {

    public static void salvarContas(List<Conta> contas, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(contas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Conta> carregarContas(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (List<Conta>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void salvarFuncionarios(List<Funcionario> funcionarios, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(funcionarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Funcionario> carregarFuncionarios(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (List<Funcionario>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}