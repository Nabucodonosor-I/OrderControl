package com.ordercontrol.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.*;

import com.ordercontrol.ExtendsSwing.RoundedButton;
import com.ordercontrol.ExtendsSwing.RoundedPanel;

import Conexao.Evento;
import Conexao.CRUD.Read;

public class FrameCadastroEvnt extends JFrame implements ActionListener, AdjustmentListener {

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
        frame.setResizable(false);
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
        scrollBar.addAdjustmentListener(this);

        panelSuperior.setBounds(15, 15, 700, 100);

        Read read = new Read();
        ArrayList<Evento> listaEventos = new ArrayList<>();
        listaEventos = read.listarEventos();
        ArrayList<JPanel> panels = new ArrayList<>();
        ArrayList<JLabel> labels = new ArrayList<>();

        int x = 30;
        int y = 150;
        int panelWidth = 215;
        int panelHeight = 200;
        int spacing = 15;


        for (Evento evento : listaEventos) {
            JPanel eventoPanel = new JPanel();
            eventoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            eventoPanel.setBackground(new Color(0, 0, 0));
            eventoPanel.setLayout(null);    
            eventoPanel.setBounds(x, y, panelWidth, panelHeight);

            
            JLabel nomeClienteLabel = new JLabel("Cliente: " + evento.getNomeCliente(), SwingConstants.CENTER);
            nomeClienteLabel.setBackground(new Color(255, 255, 255));
            nomeClienteLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            nomeClienteLabel.setBounds(x, y + 10, panelWidth, 20);
            labels.add(nomeClienteLabel);

            JLabel tipoEventoLabel = new JLabel("Tipo: " + evento.getTipoEventoToString(), SwingConstants.CENTER);
            tipoEventoLabel.setBackground(new Color(255, 255, 255));
            tipoEventoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            tipoEventoLabel.setBounds(x, y + 30, panelWidth, 20);
            labels.add(tipoEventoLabel);

            JLabel localLabel = new JLabel("Local: " + evento.getLocal(), SwingConstants.CENTER);
            localLabel.setBackground(new Color(255, 255, 255));
            localLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            localLabel.setBounds(x, y + 50, panelWidth, 20);
            labels.add(localLabel);

            JLabel horaLabel = new JLabel("Hora: " + evento.getHora(), SwingConstants.CENTER);
            horaLabel.setBackground(new Color(255, 255, 255));
            horaLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            horaLabel.setBounds(x, y + 70, panelWidth, 20);
            labels.add(horaLabel);

            JLabel dataLabel = new JLabel("Data: " + evento.getData(), SwingConstants.CENTER);
            dataLabel.setBackground(new Color(255, 255, 255));
            dataLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            dataLabel.setBounds(x, y + 90, panelWidth, 20);
            labels.add(dataLabel);

            JLabel descricaoLabel = new JLabel("Descrição: " + evento.getData(), SwingConstants.CENTER);
            descricaoLabel.setBackground(new Color(255, 255, 255));
            descricaoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
            descricaoLabel.setBounds(x, y + 110, panelWidth, 20);
            labels.add(descricaoLabel);
            
            panels.add(eventoPanel);
            frame.add(nomeClienteLabel);
            frame.add(tipoEventoLabel);
            frame.add(localLabel);
            frame.add(horaLabel);
            frame.add(dataLabel);
            frame.add(descricaoLabel);
            frame.add(eventoPanel);
            frame.revalidate();
            frame.repaint();
            
            x += panelWidth + spacing;
            if ((2 * 30) + (3 * spacing) + (3 * panelWidth) == 750) {
                    x = 30;
                    y += panelHeight + spacing;
                }
            }
            
            
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
        } else if (o == addButton) {
            AddEvento newEvento = new AddEvento();

        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adjustmentValueChanged'");
    }
}
