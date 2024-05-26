package com.ordercontrol;

import javax.swing.*;

import com.ordercontrol.ExtendsSwing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEvento extends JFrame implements ActionListener {

    String currentDirectory = System.getProperty("user.dir");

    JFrame framePrincipal = new JFrame();
    RoundedButton cadastroButton = new RoundedButton(10, new Color(54, 54, 54), null);
    JButton exitButton = new JButton("x");
    JLabel principalLabel = new JLabel();
    RoundedPanel painel = new RoundedPanel(20, new Color(28, 35, 43));
    ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\java\\com\\ordercontrol\\Imagens\\68386.png");
    // ImageIcon imageIcon2 = new ImageIcon(
    //         new ImageIcon(
    //                 currentDirectory+"\\demo\\src\\main\\java\\com\\ordercontrol\\Imagens\\Logo.png")
    //                 .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

    CustomRadioButton masculino = new CustomRadioButton(new Color(0, 0, 0));
    CustomRadioButton feminino = new CustomRadioButton(new Color(0, 0, 0));
    ButtonGroup group = new ButtonGroup();

    JTextField usuario = new JTextField();
    JTextField email = new JTextField();
    JTextField cpf = new JTextField();
    JTextField senha = new JTextField();
    JTextField idade = new JTextField();
    JButton submit = new JButton("Enviar ");
    JLabel label = new JLabel();
    JLabel senhaLabel = new JLabel();
    JLabel usuarioLabel = new JLabel();
    JLabel emailLabel = new JLabel();
    JLabel cpfLabel = new JLabel();
    JLabel bemVindo = new JLabel();
    JLabel credenciais = new JLabel();
    JLabel orderConttrl = new JLabel();
    JLabel masculinoLabel = new JLabel();
    JLabel femininoLabel = new JLabel();
    JLabel adminJLabel = new JLabel();
    JLabel idadeLabel = new JLabel();
    CustomRadioButton adminCheck = new CustomRadioButton(new Color(0, 0, 0));

    public AddEvento() {
        // configurações frame
        framePrincipal.setSize(750, 600);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setResizable(false);
        // framePrincipal.setUndecorated(true);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());

        // config painel
        // painel.setBounds(15, 15, 350, 530);

        // config text field usuario
        usuario.setBounds(85, 115, 210, 30);
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
        senha.setBounds(85, 190, 210, 150);
        senha.setHorizontalAlignment(SwingConstants.CENTER);
        senha.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field idade
        idade.setBounds(470, 385, 50, 30);
        idade.setHorizontalAlignment(SwingConstants.CENTER);
        idade.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // configurações label senha
        senhaLabel.setText("Descrição ");
        senhaLabel.setForeground(new Color(0, 0, 0));
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        senhaLabel.setBounds(85, 165, 125, 25);

        // configurações label nome
        usuarioLabel.setText("Nome do cliente ");
        usuarioLabel.setForeground(new Color(0, 0, 0));
        usuarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usuarioLabel.setBounds(85, 80, 125, 25);

        // config label email
        emailLabel.setText("Nome do cliente ");
        emailLabel.setForeground(new Color(0, 0, 0));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        emailLabel.setBounds(470, 230, 125, 25);

        // config label idade
        idadeLabel.setText("Local");
        idadeLabel.setForeground(new Color(0, 0, 0));
        idadeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        idadeLabel.setBounds(470, 360, 125, 25);

        // config label cpfLabel
        cpfLabel.setText("CEP");
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
        orderConttrl.setForeground(new Color(0, 0, 0));
        orderConttrl.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        orderConttrl.setBounds(95, 45, 300, 40);

        // config Label feminino
        femininoLabel.setText("Orçamento ");
        femininoLabel.setForeground(new Color(0, 0, 0));
        femininoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        femininoLabel.setBounds(590, 430, 80, 25);

        // config Label feminino
        masculinoLabel.setText("Ordem de serviço ");
        masculinoLabel.setForeground(new Color(0, 0, 0));
        masculinoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        masculinoLabel.setBounds(490, 430, 80, 25);

        adminJLabel.setText("Usuario Administrador ");
        adminJLabel.setForeground(new Color(0, 0, 0));
        adminJLabel.setFont(new Font("Arial", Font.BOLD, 15));
        adminJLabel.setBounds(490, 465, 200, 25);

        // configuração botão cadastro
        cadastroButton.setText("Cadastrar");
        cadastroButton.setBounds(470, 500, 200, 50);
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

        // Config Check admin
        adminCheck.setBounds(470, 465, 20, 20);
        adminCheck.setOpaque(false);

        // Configuração botão de saida
        exitButton.setBounds(705, 0, 45, 45);
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setForeground(new Color(0, 0, 0));
        exitButton.addActionListener(this);

        // configurações label
        principalLabel.setBounds(95, 55, 200, 200);
        principalLabel.setForeground(new Color(255, 0, 0));
        principalLabel.setFont(new Font("MV Boli", Font.BOLD, 25));
        // principalLabel.setIcon(imageIcon2);
        principalLabel.setHorizontalTextPosition(JLabel.CENTER);
        principalLabel.setVerticalTextPosition(JLabel.BOTTOM);
        principalLabel.setIconTextGap(-70);
        principalLabel.setVerticalAlignment(JLabel.CENTER);
        principalLabel.setHorizontalAlignment(JLabel.CENTER);

        // config grupo de botão
        group.add(masculino);
        group.add(feminino);

        // adicionado
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
        // framePrincipal.add(bemVindo);
        // framePrincipal.add(credenciais);
        framePrincipal.add(orderConttrl);
        // framePrincipal.add(painel);
        framePrincipal.add(adminJLabel);
        framePrincipal.add(adminCheck);
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

    // Valida se idade é um número ,se não, insere como zero
    // Futuramente não deixar concluir cadastro *
    public Integer getIdade() {
        try {
            int intIdade = Integer.parseInt(idade.getText());
            return intIdade;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Idade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    // public String getSexo(){
    // if(masculino = 1 && feminino = 0){

    // }
    // }

    public String getCpf() {
        return cpf.getText();
    }

    // acionamento do botão login

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == cadastroButton) {
            // framePrincipal.dispose();
            // TelaCadastroLogin tela = new TelaCadastroLogin();
        } else if (o == exitButton) {
            framePrincipal.dispose();
        }
    }
}