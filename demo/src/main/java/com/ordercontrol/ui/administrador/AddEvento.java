package com.ordercontrol.ui.administrador;

import javax.swing.*;

import com.ordercontrol.DAO.CRUD.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEvento implements ActionListener {

    private final String currentDirectory = System.getProperty("user.dir");
    
    private final JFrame framePrincipal = new JFrame();
    private final RoundedButton cadastroButton = new RoundedButton(10, new Color(54, 54, 54), null);
    private final ImageIcon imageIcon1 = new ImageIcon(
         currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\68386.png");
    private final CustomRadioButton ordemServ = new CustomRadioButton(new Color(0, 0, 0));
    private final CustomRadioButton orcam = new CustomRadioButton(new Color(0, 0, 0));
    private final ButtonGroup group = new ButtonGroup();
    private final RoundedPanel painel = new RoundedPanel(20, new Color(28, 35, 43));
    private final RoundedPanel painel2 = new RoundedPanel(20, new Color(255, 255, 255));
    private final JTextField cliente = new JTextField();
    private final JTextField local = new JTextField();
    private final JTextField data = new JTextField();
    private final JTextField descricao = new JTextField();
    private final JTextField hora = new JTextField();
    private final JLabel descricaoLabel = new JLabel();
    private final JLabel clienteLabel = new JLabel();
    private final JLabel localLabel = new JLabel();
    private final JLabel dataLabel = new JLabel();
    private final JLabel orderConttrl = new JLabel();
    private final JLabel orcanLabel = new JLabel();
    private final JLabel ordemServLabel = new JLabel();
    private final JLabel horaLabel = new JLabel();
    private TelaAdmin admin = null;

    public AddEvento(TelaAdmin admin) {
        this.admin = admin;

        // configurações frame
        framePrincipal.setSize(750, 600);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setResizable(false);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());

        // config painel
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

        // config grupo de botão
        group.add(ordemServ);
        group.add(orcam);

        // adicionado
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
        framePrincipal.add(orderConttrl);
        framePrincipal.add(horaLabel);
        framePrincipal.add(hora);
        framePrincipal.add(painel2);
        framePrincipal.add(painel);
        framePrincipal.setLayout(null);

    }

    public int tipoEvento() {
        int tipo = 0;
        if (ordemServ.isSelected()) {
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
                admin.frameDispose();
                TelaAdmin visualAdmin = new TelaAdmin();
                visualAdmin.mostrarEventos(new Read());

                framePrincipal.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadsrar usuario");
            }
        }
    }
}
