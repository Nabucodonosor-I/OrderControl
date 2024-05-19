package com.ordercontrol;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ordercontrol.ExtendsSwing.RoundedButton;
import com.ordercontrol.ExtendsSwing.RoundedPanel;

public class FrameCadastroEvnt extends JFrame implements ActionListener {

    String currentDirectory = System.getProperty("user.dir");

    ImageIcon imageIcon1 = new ImageIcon(
        currentDirectory + "\\demo\\src\\main\\java\\com\\ordercontrol\\Imagens\\68386.png");
    JFrame frame = new JFrame();
    JLabel labelAdd = new JLabel();
    JLabel cadastroLabel = new JLabel();
    JLabel logoutLabel = new JLabel();
    RoundedPanel panelSuperior = new RoundedPanel(10, new Color(28, 35, 43));
    RoundedButton addButton = new RoundedButton(20, new Color(54, 54, 54), new Color(255, 255, 255));
    RoundedButton cadastrarButton = new RoundedButton(20, new Color(54, 54, 54), new Color(255, 255, 255));
    RoundedButton logout = new RoundedButton(20, new Color(54, 54, 54), new Color(255, 255, 255));
    JScrollBar scrollBar = new JScrollBar();

    public FrameCadastroEvnt() {
        frame.setSize(750, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setLayout(null);

        addButton.setEspessuraLinha(2.0f);
        addButton.setBounds(60, 30, 140, 70);
        addButton.setBorder(BorderFactory.createRaisedBevelBorder());
        addButton.addActionListener(this);

        cadastrarButton.setEspessuraLinha(2.0f);
        cadastrarButton.setBounds(300, 30, 140, 70);
        cadastrarButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cadastrarButton.addActionListener(this);

        logout.setEspessuraLinha(2.0f);
        logout.setBounds(540, 30, 140, 70);
        logout.setBorder(BorderFactory.createRaisedBevelBorder());
        logout.addActionListener(this);

        logoutLabel.setText("Sair");
        logoutLabel.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 22));
        logoutLabel.setForeground(new Color(255, 255, 255));
        logoutLabel.setBounds(580, 15, 200, 100);

        cadastroLabel.setText("Cadastrar");
        cadastroLabel.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 21));
        cadastroLabel.setForeground(new Color(255, 255, 255));
        cadastroLabel.setBounds(323, 15, 200, 100);

        labelAdd.setText("Novo Evento");
        labelAdd.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 21));
        labelAdd.setForeground(new Color(255, 255, 255));
        labelAdd.setBounds(70, 15, 200, 100);

        scrollBar.setBounds(700, 120, 15, 450);

        panelSuperior.setBounds(15, 15, 700, 100);

        frame.add(labelAdd);
        frame.add(addButton);
        frame.add(cadastroLabel);
        frame.add(cadastrarButton);
        frame.add(logoutLabel);
        frame.add(logout);
        frame.add(scrollBar);
        frame.add(panelSuperior);
        frame.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object o = arg0.getSource();

        if (o == cadastrarButton) {
            Cadastro cadastro = new Cadastro();
        } else if(o == addButton) {
            AddEvento newEvento = new AddEvento();


        }
    }
}
