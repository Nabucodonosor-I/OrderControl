package com.ordercontrol.ui;

import javax.swing.*;

import com.ordercontrol.DAO.CRUD.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;

import java.awt.Image;
import java.awt.event.ActionEvent;

public class TelaCadastro extends ModeloTela {

    private final RoundedButton cadastroButton = new RoundedButton(10, CINZA, null);
    private final RoundedButton voltarButton = new RoundedButton(10, BRANCO, null);
    private final JLabel principalLabel = new JLabel();
    private final RoundedPanel painel = new RoundedPanel(20, AZUL);
    private final ImageIcon imageIcon3 = new ImageIcon(
            new ImageIcon(CURRENT_DIRECTORY + "\\demo\\src\\main\\resources\\Imagens\\seta2.png").getImage()
                    .getScaledInstance(70, 30, Image.SCALE_FAST));
    private final CustomRadioButton masculino = new CustomRadioButton(PRETO);
    private final CustomRadioButton feminino = new CustomRadioButton(PRETO);
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
        super(750, 600);
        configureComponents();
        addComponentsToFrame();
    }

    private void configureComponents() {
        configurePainel();
        configureButtons();
        configTextFields();
        configLabels();
        configureRadioButtons();
    }

    private void configurePainel() {
        painel.setBounds(15, 15, 350, 530);
    }

    private void configureButtons() {
        configButton(voltarButton, imageIcon3, 685, 5, 50, 50);
        configButton(cadastroButton, "Cadastrar", 470, 470, 200, 50, DEJAVU_25, BRANCO, CINZA);
    }

    private void configTextFields() {
        configTextField(usuario, 470, 115, 200, 30, SwingConstants.CENTER, BCA);
        configTextField(email, 470, 255, 200, 30, SwingConstants.CENTER, BCA);
        configTextField(cpf, 470, 325, 200, 30, SwingConstants.CENTER, BCA);
        configTextField(senha, 470, 190, 200, 30, SwingConstants.CENTER, BCA);
        configTextField(idade, 470, 385, 50, 30, SwingConstants.CENTER, BCA);
    }

    private void configLabels() {
        configLabel(senhaLabel, "Senha ", PRETO, ARIAL_15, 470, 165, 125, 25);
        configLabel(usuarioLabel, "Nome completo ", PRETO, ARIAL_15, 470, 80, 125, 25);
        configLabel(emailLabel, "E-mail ", PRETO, ARIAL_15, 470, 230, 125, 25);
        configLabel(cpfLabel, "CPF", PRETO, ARIAL_15, 470, 300, 125, 25);
        configLabel(idadeLabel, "Idade", PRETO, ARIAL_15, 470, 360, 125, 25);
        configLabel(femininoLabel, "Feminino ", PRETO, ARIAL_15, 590, 430, 80, 25);
        configLabel(masculinoLabel, "Masculino ", PRETO, ARIAL_15, 490, 430, 80, 25);
        configLabel(bemVindo, "Bem Vindo", BRANCO, ARIAL_25, 130, 30, 300, 40);
        configLabel(credenciais, "Insira seus dados: ", PRETO, ARIAL_15, 400, 20, 300, 30);
        configPrincipalLabel(orderConttrl, 95, 55, 150, 150);
    }

    private void configureRadioButtons() {
        configRadioButton(masculino, 470, 430, 20, 20);
        configRadioButton(feminino, 570, 430, 20, 20);
        group.add(masculino);
        group.add(feminino);
    }

    private void addComponentsToFrame() {
        add(voltarButton);
        add(principalLabel);
        add(email);
        add(cpf);
        add(cadastroButton);
        add(masculino);
        add(feminino);
        add(usuario);
        add(senha);
        add(senhaLabel);
        add(usuarioLabel);
        add(emailLabel);
        add(cpfLabel);
        add(femininoLabel);
        add(masculinoLabel);
        add(bemVindo);
        add(credenciais);
        add(orderConttrl);
        add(painel);
        add(idadeLabel);
        add(idade);
        setLayout(null);
    }

    // Getters
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
            Usuario user = new Usuario(getUsuario(), getSenha(), getEmail(), getSexo(), getCpf(), getIdade());
            Create cadastrar = new Create();
            boolean criarUsuario = cadastrar.criarUsuario(user);
            if (criarUsuario) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado");
                dispose();
                new TelaPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário");
            }
        } else if (o == voltarButton) {
            new TelaPrincipal();
            dispose();
        }
    }
}
