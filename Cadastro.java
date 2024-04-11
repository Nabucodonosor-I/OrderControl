import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro implements ActionListener {
    JFrame cadastro = new JFrame();
    JTextField nome = new JTextField();
    JTextField idade = new JTextField();
    JTextField email = new JTextField();
    JTextField cpf = new JTextField();
    JLabel nomeLabel = new JLabel();
    JLabel idadeLabel = new JLabel();
    JLabel emailLabel = new JLabel();
    JLabel cpfLabel = new JLabel();
    JButton enviar = new JButton();

    Cadastro() {
        cadastro.setSize(500, 500);
        cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadastro.setResizable(false);
        cadastro.setVisible(true);
        cadastro.setLayout(null);
        cadastro.setLocationRelativeTo(null);
        cadastro.getContentPane().setBackground(new Color(255, 222, 173));

        nome.setBounds(195, 200, 115, 25);
        idade.setBounds(195, 230, 115, 25);
        email.setBounds(195, 260, 115, 25);
        cpf.setBounds(195, 290, 115, 25);

        nomeLabel.setBounds(150, 200, 115, 25);
        nomeLabel.setText("Nome: ");
        idadeLabel.setBounds(150, 230, 115, 25);
        idadeLabel.setText("Idade: ");
        emailLabel.setBounds(150, 260, 115, 25);
        emailLabel.setText("E-mail: ");
        cpfLabel.setBounds(150, 290, 115, 25);
        cpfLabel.setText("Cpf: ");

        // configuração do botão enviar
        enviar.setText("Enviar");
        enviar.setBounds(175, 350, 150, 50);
        enviar.addActionListener(this);

        cadastro.add(nome);
        cadastro.add(idade);
        cadastro.add(email);
        cadastro.add(cpf);
        cadastro.add(nomeLabel);
        cadastro.add(idadeLabel);
        cadastro.add(emailLabel);
        cadastro.add(cpfLabel);
        cadastro.add(enviar);

    }

    public String getNome() {
        return nome.getText();
    }

    public String getIdade() {
        return idade.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getCpf() {
        return cpf.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();


    }
}
