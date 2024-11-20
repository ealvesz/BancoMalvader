package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Banco Malvader - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField campoUsuario = new JTextField();
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();
        JButton botaoFuncionario = new JButton("Login Funcionário");
        JButton botaoCliente = new JButton("Login Cliente");

        panel.add(labelUsuario);
        panel.add(campoUsuario);
        panel.add(labelSenha);
        panel.add(campoSenha);
        panel.add(botaoFuncionario);
        panel.add(botaoCliente);

        add(panel, BorderLayout.CENTER);

        botaoFuncionario.addActionListener(e -> autenticarFuncionario());
        botaoCliente.addActionListener(e -> autenticarCliente());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void autenticarFuncionario() {
        // Lógica de autenticação do funcionário
        JOptionPane.showMessageDialog(this, "Funcionário autenticado!");
    }

    private void autenticarCliente() {
        // Lógica de autenticação do cliente
        JOptionPane.showMessageDialog(this, "Cliente autenticado!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin());
    }
}