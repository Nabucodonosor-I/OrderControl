package com.ordercontrol.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Conexao.Evento;

public class FrameDetahles {

    JFrame framePrincipal = new JFrame();
    String currentDirectory = System.getProperty("user.dir");
    ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\java\\com\\ordercontrol\\Imagens\\68386.png");
    ImageIcon imageIcon2 = new ImageIcon(
            new ImageIcon(
                    currentDirectory + "\\demo\\src\\main\\java\\com\\ordercontrol\\Imagens\\Logo.png")
                    .getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));

    JLabel nomeClienteLabel = new JLabel();
    JLabel tipoEventoLabel = new JLabel();
    JLabel localLabel = new JLabel();
    JLabel horaLabel = new JLabel();
    JLabel dataLabel = new JLabel();
    JLabel descricaoLabel = new JLabel();

    FrameDetahles(Evento evento) {
        // configurações frame
        framePrincipal.setSize(750, 600);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setResizable(false);
        // framePrincipal.setUndecorated(true);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());

        nomeClienteLabel.setText("Cliente: " + evento.getNomeCliente());
        nomeClienteLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        tipoEventoLabel.setText("Tipo: " + evento.getTipoEventoToString());
        tipoEventoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        localLabel.setText("Local: " + evento.getLocal());
        localLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        horaLabel.setText("Hora: " + evento.getHora());
        horaLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        dataLabel.setText("Data: " + evento.getData());
        dataLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        descricaoLabel.setText("Descrição: " + evento.getDescricao());
        descricaoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        framePrincipal.add(nomeClienteLabel);
        framePrincipal.add(tipoEventoLabel);
        framePrincipal.add(localLabel);
        framePrincipal.add(horaLabel);
        framePrincipal.add(dataLabel);
        framePrincipal.add(descricaoLabel);

    }

}
