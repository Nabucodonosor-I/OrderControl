package com.ordercontrol.ui;

import com.ordercontrol.DAO.UsuarioDAO;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;
import com.ordercontrol.ui.comum.TelaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaLogin extends ModeloTela {

    String senhaUser;
    String usuarioUser;

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    private final RoundedButton loginButton = new RoundedButton(10, CINZA, null);
    private final RoundedButton cadastroButton = new RoundedButton(10, CINZA, null);
    private final JLabel principalLabel = new JLabel();
    private final RoundedPanel painel = new RoundedPanel(20, AZUL);
    private final JTextField usuario = new JTextField();
    private final JPasswordField senha = new JPasswordField();
    private final JLabel senhaLabel = new JLabel();
    private final JLabel usuarioLabel = new JLabel();
    private final JLabel bemVindo = new JLabel();
    private final JLabel credenciais = new JLabel();
    private final JLabel orderConttrl = new JLabel();
    private final JLabel descricao1 = new JLabel();
    private final JLabel descricao2 = new JLabel();

    private JLabel erro;

    public TelaLogin() {
        super(750, 600);

        configureComponents();
        addComponentsToFrame();
    }

    private void configureComponents() {
        configPainel();
        configTextFields();
        configButtons();
        configLabels();
    }

    private void configPainel() {
        painel.setBounds(15, 15, 350, 530);
    }

    private void configTextFields() {
        usuario.setBounds(470, 200, 200, 30);
        usuario.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBorder(BCA);

        senha.setBounds(470, 275, 200, 30);
        senha.setHorizontalAlignment(SwingConstants.CENTER);
        senha.setBorder(BCA);
    }

    private void configButtons() {
        configButton(loginButton, "Login", 470, 375, 200, 50);
        configButton(cadastroButton, "Cadastrar", 470, 450, 200, 50);
    }

    private void configLabels() {
        configPrincipalLabel(principalLabel, 95, 35, 150, 150);
        configLabel(senhaLabel, "Senha", PRETO, ARIAL_15, 470, 250, 125, 25);
        configLabel(usuarioLabel, "E-mail", PRETO, ARIAL_15, 470, 175, 125, 25);
        configLabel(bemVindo, "Bem Vindo", PRETO, ARIAL_25, 400, 40, 200, 30);
        configLabel(credenciais, "Insira suas Credenciais, por favor", PRETO, ARIAL_13, 400, 63, 300, 30);
        configLabel(orderConttrl, "OrderControl", BRANCO, BAUHAUS, 105, 240, 300, 40);
        configLabel(descricao1, "Nós ajudamos a agendar e gerenciar", BRANCO, ARIAL_15, 37, 390, 300, 100);
        configLabel(descricao2, "visitas e orçamentos de forma eficiente.", BRANCO, ARIAL_15, 37, 410, 300, 100);
    }

    private void addComponentsToFrame() {
        add(principalLabel);
        add(loginButton);
        add(cadastroButton);
        add(usuario);
        add(senha);
        add(senhaLabel);
        add(usuarioLabel);
        add(bemVindo);
        add(credenciais);
        add(orderConttrl);
        add(descricao1);
        add(descricao2);
        add(painel);
        setLayout(null);
    }

    @SuppressWarnings("deprecation")
    public String getPassword() {
        return new String(senha.getText());
    }

    public String getTextUsuario() {
        return usuarioUser = usuario.getText();

    }

    private void displayErroMessage(String message, int x, int y, int width, int height) {
        if (erro != null) {
            remove(erro);
            repaint();
            erro = null;
        } else {
            erro = new JLabel();
            configLabel(erro, message, VERMELHO, ARIAL_12, x, y, width, height);
            add(erro);
            repaint();
        }
    }

    private void cadastro() {
        new TelaCadastro();
        dispose();
    }

    private void login() {
        String usuarioText = getTextUsuario();
        String senhaChars = getPassword();

        if (usuarioText.isEmpty() || senhaChars.isEmpty()) {
            displayErroMessage("Campos Obrigatorios", 470, 100, 200, 100);
        } else {

            Usuario usuario = usuarioDAO.lerUsuario(usuarioText, senhaChars);

            if (usuario != null) {
                if (usuario.getAdmin() == 1) {
                    new TelaPrincipal(usuario, true);
                    dispose();
                } else if (usuario.getAdmin() == 0) {
                    dispose();
                    new TelaPrincipal(usuario, false);
                }
            } else {
                displayErroMessage("Usuarios ou senha invalidos", 470, 100, 200, 100);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == loginButton) {
            login();
        } else if (o == cadastroButton) {
            cadastro();
        }
    }
}
