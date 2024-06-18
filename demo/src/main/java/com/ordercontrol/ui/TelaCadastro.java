package com.ordercontrol.ui;

import javax.swing.*;

import com.ordercontrol.DAO.CRUD.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro implements ActionListener {

    private final String currentDirectory = System.getProperty("user.dir");

    private final JFrame framePrincipal = new JFrame();
    private final RoundedButton cadastroButton = new RoundedButton(10, new Color(54, 54, 54), null);
    private final RoundedButton voltarButton = new RoundedButton(10, new Color(255, 255, 255), null);

    private final JLabel principalLabel = new JLabel();
    private final RoundedPanel painel = new RoundedPanel(20, new Color(28, 35, 43));
    private final ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\68386.png");
    private final ImageIcon imageIcon2 = new ImageIcon(
            new ImageIcon(
                    currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\Logo.png")
                    .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

    private final ImageIcon imageIcon3 = new ImageIcon(
            new ImageIcon(
                    currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\seta2.png")
                    .getImage().getScaledInstance(70, 30, Image.SCALE_FAST));

    private final CustomRadioButton masculino = new CustomRadioButton(new Color(0, 0, 0));
    private final CustomRadioButton feminino = new CustomRadioButton(new Color(0, 0, 0));
    private final ButtonGroup group = new ButtonGroup();

    private final JTextField usuario = new JTextField();
    private final JTextField email = new JTextField();
    private final JTextField cpf = new JTextField();
    private final JTextField senha = new JTextField();
    private final JTextField idade = new JTextField();
    private final JLabel senhaLabel = new JLabel();
    private final JLabel usuarioLabel = new JLabel();
    private final JLabel emailLabel = new JLabel();
    private final JLabel cpfLabel = new JLabel();
    private final JLabel bemVindo = new JLabel();
    private final JLabel credenciais = new JLabel();
    private final JLabel orderConttrl = new JLabel();
    private final JLabel masculinoLabel = new JLabel();
    private final JLabel femininoLabel = new JLabel();
    private final JLabel idadeLabel = new JLabel();

    public TelaCadastro() {
        // configurações frame
        framePrincipal.setSize(750, 600);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setResizable(false);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());

        // config painel
        painel.setBounds(15, 15, 350, 530);

        voltarButton.setIcon(imageIcon3);
        voltarButton.setBounds(685, 5, 50, 50);
        voltarButton.setFocusable(false);
        voltarButton.setBorder(BorderFactory.createRaisedBevelBorder());
        voltarButton.addActionListener(this);

        // config text field usuario
        usuario.setBounds(470, 115, 200, 30);
        usuario.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field e-mail
        email.setBounds(470, 255, 200, 30);
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text fild cpf
        cpf.setBounds(470, 325, 200, 30);
        cpf.setHorizontalAlignment(SwingConstants.CENTER);
        cpf.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field senha
        senha.setBounds(470, 190, 200, 30);
        senha.setHorizontalAlignment(SwingConstants.CENTER);
        senha.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field idade
        idade.setBounds(470, 385, 50, 30);
        idade.setHorizontalAlignment(SwingConstants.CENTER);
        idade.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // configurações label senha
        senhaLabel.setText("Senha ");
        senhaLabel.setForeground(new Color(0, 0, 0));
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        senhaLabel.setBounds(470, 165, 125, 25);

        // configurações label nome
        usuarioLabel.setText("Nome completo ");
        usuarioLabel.setForeground(new Color(0, 0, 0));
        usuarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usuarioLabel.setBounds(470, 80, 125, 25);

        // config label email
        emailLabel.setText("E-mail ");
        emailLabel.setForeground(new Color(0, 0, 0));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        emailLabel.setBounds(470, 230, 125, 25);

        // config label idade
        idadeLabel.setText("Idade");
        idadeLabel.setForeground(new Color(0, 0, 0));
        idadeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        idadeLabel.setBounds(470, 360, 125, 25);

        // config label cpfLabel
        cpfLabel.setText("CPF");
        cpfLabel.setForeground(new Color(0, 0, 0));
        cpfLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cpfLabel.setBounds(470, 300, 125, 25);

        // config Label Bem vindo
        bemVindo.setText("Bem Vindo");
        bemVindo.setForeground(new Color(255, 255, 255));
        bemVindo.setFont(new Font("Arial", Font.BOLD, 25));
        bemVindo.setBounds(130, 30, 300, 40);

        // config label credenciais
        credenciais.setText("Insira seus dados: ");
        credenciais.setForeground(new Color(0, 0, 0));
        credenciais.setFont(new Font("Arial", Font.BOLD, 13));
        credenciais.setBounds(400, 20, 300, 30);

        // config Label OrderControl
        orderConttrl.setText("OrderControl");
        orderConttrl.setForeground(new Color(255, 255, 255));
        orderConttrl.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        orderConttrl.setBounds(105, 240, 300, 40);

        // config Label feminino
        femininoLabel.setText("Feminino ");
        femininoLabel.setForeground(new Color(0, 0, 0));
        femininoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        femininoLabel.setBounds(590, 430, 80, 25);

        // config Label feminino
        masculinoLabel.setText("Masculino ");
        masculinoLabel.setForeground(new Color(0, 0, 0));
        masculinoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        masculinoLabel.setBounds(490, 430, 80, 25);

        // configuração botão cadastro
        cadastroButton.setText("Cadastrar");
        cadastroButton.setBounds(470, 470, 200, 50);
        cadastroButton.setFocusable(false);
        cadastroButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        cadastroButton.setForeground(new Color(255, 255, 255));
        cadastroButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cadastroButton.addActionListener(this);

        // config botão masculino
        masculino.setBounds(470, 430, 20, 20);
        masculino.setOpaque(false);

        // confing botão feminino
        feminino.setBounds(570, 430, 20, 20);
        feminino.setOpaque(false);

        // configurações label
        principalLabel.setBounds(95, 55, 200, 200);
        principalLabel.setForeground(new Color(255, 0, 0));
        principalLabel.setFont(new Font("MV Boli", Font.BOLD, 25));
        principalLabel.setIcon(imageIcon2);
        principalLabel.setHorizontalTextPosition(JLabel.CENTER);
        principalLabel.setVerticalTextPosition(JLabel.BOTTOM);
        principalLabel.setIconTextGap(-70);
        principalLabel.setVerticalAlignment(JLabel.CENTER);
        principalLabel.setHorizontalAlignment(JLabel.CENTER);

        // config grupo de botão
        group.add(masculino);
        group.add(feminino);

        // adicionado
        framePrincipal.add(voltarButton);
        framePrincipal.add(principalLabel);
        framePrincipal.add(email);
        framePrincipal.add(cpf);
        framePrincipal.add(cadastroButton);
        framePrincipal.add(masculino);
        framePrincipal.add(feminino);
        framePrincipal.add(usuario);
        framePrincipal.add(senha);
        framePrincipal.add(senhaLabel);
        framePrincipal.add(usuarioLabel);
        framePrincipal.add(emailLabel);
        framePrincipal.add(cpfLabel);
        framePrincipal.add(femininoLabel);
        framePrincipal.add(masculinoLabel);
        framePrincipal.add(bemVindo);
        framePrincipal.add(credenciais);
        framePrincipal.add(orderConttrl);
        framePrincipal.add(painel);
        framePrincipal.add(idadeLabel);
        framePrincipal.add(idade);
        framePrincipal.setLayout(null);

    }

    public String getSenha() {
        return senha.getText();
    }

    public String getUsuario() {
        return usuario.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getSexo() {
        if (masculino.isSelected()) {
            return "m";
        } else if (feminino.isSelected()) {
            return "f";
        }
        return null;
    }

    public int getCpf() {
        return Integer.parseInt(cpf.getText());
    }

    public int getIdade() {
        return Integer.parseInt(idade.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == cadastroButton) {
            Usuario user = new Usuario(usuario.getText(), senha.getText(), email.getText(), getSexo(), getCpf(),
                    getIdade());
            Create cadastrar = new Create();
            boolean criarUsuario = cadastrar.criarUsuario(user);
            if (criarUsuario = true) {
                JOptionPane.showMessageDialog(null, "Usuario cadastrado");
                framePrincipal.dispose();
                TelaPrincipal telaPrincipal = new TelaPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadsrar usuario");
            }
        } else if (o == voltarButton) {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            framePrincipal.dispose();
        }
    }
}