package com.ordercontrol.ui;

import javax.swing.*;

import com.ordercontrol.DAO.CRUD.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;

import java.awt.Color;
import java.awt.Font;
// import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AddEvento extends JFrame implements ActionListener {

    String currentDirectory = System.getProperty("user.dir");
    
    ValidarUsuario validar = new ValidarUsuario();

    JFrame framePrincipal = new JFrame();
    RoundedButton cadastroButton = new RoundedButton(10, new Color(54, 54, 54), null);
    JButton exitButton = new JButton("x");
    JLabel principalLabel = new JLabel();
    ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\68386.png");
    CustomRadioButton ordemServ = new CustomRadioButton(new Color(0, 0, 0));
    CustomRadioButton orcam = new CustomRadioButton(new Color(0, 0, 0));
    ButtonGroup group = new ButtonGroup();
    RoundedPanel painel = new RoundedPanel(20, new Color(28, 35, 43));
    RoundedPanel painel2 = new RoundedPanel(20, new Color(255, 255, 255));
    JTextField cliente = new JTextField();
    JTextField local = new JTextField();
    JTextField data = new JTextField();
    JTextField descricao = new JTextField();
    JTextField hora = new JTextField();
    JButton submit = new JButton("Enviar ");
    JLabel label = new JLabel();
    JLabel descricaoLabel = new JLabel();
    JLabel clienteLabel = new JLabel();
    JLabel localLabel = new JLabel();
    JLabel dataLabel = new JLabel();
    JLabel bemVindo = new JLabel();
    JLabel credenciais = new JLabel();
    JLabel orderConttrl = new JLabel();
    JLabel orcanLabel = new JLabel();
    JLabel ordemServLabel = new JLabel();
    JLabel horaLabel = new JLabel();

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

        //config painel
        painel.setBounds(15, 15, 705, 530);
        painel2.setBounds(25, 25, 685, 510);

        // config text field cliente
        cliente.setBounds(85, 115, 210, 30);
        cliente.setHorizontalAlignment(SwingConstants.CENTER);
        cliente.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field local
        local.setBounds(425, 115, 210, 30);
        local.setHorizontalAlignment(SwingConstants.CENTER);
        local.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text fild data
        data.setBounds(425, 190, 210, 30);
        data.setHorizontalAlignment(SwingConstants.CENTER);
        data.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field descricao
        descricao.setBounds(85, 190, 210, 150);
        descricao.setHorizontalAlignment(SwingConstants.CENTER);
        descricao.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field hora
        hora.setBounds(425, 265, 100, 30);
        hora.setHorizontalAlignment(SwingConstants.CENTER);
        hora.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // configurações label descricao
        descricaoLabel.setText("Descrição ");
        descricaoLabel.setForeground(new Color(0, 0, 0));
        descricaoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        descricaoLabel.setBounds(85, 165, 125, 25);

        // configurações label nome
        clienteLabel.setText("Nome do cliente ");
        clienteLabel.setForeground(new Color(0, 0, 0));
        clienteLabel.setFont(new Font("Arial", Font.BOLD, 15));
        clienteLabel.setBounds(85, 90, 125, 25);

        // config label local
        localLabel.setText("Local do Evento ");
        localLabel.setForeground(new Color(0, 0, 0));
        localLabel.setFont(new Font("Arial", Font.BOLD, 15));
        localLabel.setBounds(425, 90, 125, 25);

        // config label hora
        horaLabel.setText("Hora do evento");
        horaLabel.setForeground(new Color(0, 0, 0));
        horaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        horaLabel.setBounds(425, 240, 125, 25);

        // config label dataLabel
        dataLabel.setText("Data do evento");
        dataLabel.setForeground(new Color(0, 0, 0));
        dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
        dataLabel.setBounds(425, 165, 125, 25);

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
        orderConttrl.setBounds(260, 45, 300, 40);

        // config Label orcamento
        ordemServLabel.setText("Ordem de serviço ");
        ordemServLabel.setForeground(new Color(0, 0, 0));
        ordemServLabel.setFont(new Font("Arial", Font.BOLD, 15));
        ordemServLabel.setBounds(520, 320, 140, 25);

        // config Label ordem
        orcanLabel.setText("Orçamento ");
        orcanLabel.setForeground(new Color(0, 0, 0));
        orcanLabel.setFont(new Font("Arial", Font.BOLD, 15));
        orcanLabel.setBounds(420, 320, 110, 25);

        // configuração botão cadastro
        cadastroButton.setText("Cadastrar");
        cadastroButton.setBounds(250, 400, 200, 50);
        cadastroButton.setFocusable(false);
        cadastroButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        cadastroButton.setForeground(new Color(255, 255, 255));
        cadastroButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cadastroButton.addActionListener(this);

        // config botão ordemServ
        ordemServ.setBounds(500, 320, 20, 20);
        ordemServ.setOpaque(false);

        // confing botão orcam
        orcam.setBounds(400, 320, 20, 20);
        orcam.setOpaque(false);


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
        group.add(ordemServ);
        group.add(orcam);

        // adicionado
        framePrincipal.add(principalLabel);
        framePrincipal.add(local);
        framePrincipal.add(data);
        framePrincipal.add(cadastroButton);
        framePrincipal.add(ordemServ);
        framePrincipal.add(orcam);
        framePrincipal.add(cliente);
        framePrincipal.add(descricao);
        framePrincipal.add(descricaoLabel);
        framePrincipal.add(clienteLabel);
        framePrincipal.add(localLabel);
        framePrincipal.add(dataLabel);
        framePrincipal.add(ordemServLabel);
        framePrincipal.add(orcanLabel);
        // framePrincipal.add(bemVindo);
        // framePrincipal.add(credenciais);
        framePrincipal.add(orderConttrl);
        framePrincipal.add(horaLabel);
        framePrincipal.add(hora);
        framePrincipal.add(painel2);
        framePrincipal.add(painel);
        framePrincipal.setLayout(null);

    }

    public int tipoEvento() {
        int tipo = 0;
        if(ordemServ.isSelected()) {
            tipo = 0;
        } else if (orcam.isSelected()) {
            tipo = 1;
        }
        return tipo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == cadastroButton) {
            Evento evento = new Evento(tipoEvento(), cliente.getText(), local.getText(), data.getText(), hora.getText(),
                    descricao.getText());
            Create cadastrar = new Create();
            boolean criarEvento = cadastrar.criarEvento(evento);
            if (criarEvento = true) {
                JOptionPane.showMessageDialog(null, "Evento cadastrado");
                VisualAdmin visualAdmin = new VisualAdmin();
                visualAdmin.mostrarEventos();
                
                framePrincipal.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadsrar usuario");
            }
        } else if (o == exitButton) {
            framePrincipal.dispose();
        }
    }
}