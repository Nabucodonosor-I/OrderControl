package com.ordercontrol.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.ordercontrol.ExtendsSwing.RoundedButton;
import com.ordercontrol.ExtendsSwing.RoundedPanel;

import Conexao.Evento;
import Conexao.CRUD.Delete;

public class FrameDetahles implements ActionListener {

    JFrame framePrincipal = new JFrame();
    String currentDirectory = System.getProperty("user.dir");
    ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\java\\com\\ordercontrol\\Imagens\\68386.png");

    JLabel nomeClienteLabel = new JLabel();
    JLabel tipoEventoLabel = new JLabel();
    JLabel localLabel = new JLabel();
    JLabel horaLabel = new JLabel();
    JLabel dataLabel = new JLabel();
    JLabel descricaoLabel = new JLabel();

    RoundedPanel painel = new RoundedPanel(10, new Color(28, 35, 43));
    RoundedButton deletar = new RoundedButton(10, new Color(54, 54, 54), null);

    VisualAdmin visualAdmin = null;

    FrameDetahles(Evento evento) {
        // configurações frame
        framePrincipal.setSize(300, 400);
        framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // framePrincipal.setResizable(false);
        // framePrincipal.setUndecorated(true);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());

        nomeClienteLabel.setText("Cliente: " + evento.getNomeCliente());
        nomeClienteLabel.setBounds(15, 15, 300, 50);
        nomeClienteLabel.setForeground(new Color(255, 255, 255));
        nomeClienteLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        tipoEventoLabel.setText("Tipo: " + evento.getTipoEventoToString());
        tipoEventoLabel.setBounds(15, 30, 300, 50);
        tipoEventoLabel.setForeground(new Color(255, 255, 255));
        tipoEventoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        localLabel.setText("Local: " + evento.getLocal());
        localLabel.setBounds(15, 45, 300, 50);
        localLabel.setForeground(new Color(255, 255, 255));
        localLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        horaLabel.setText("Hora: " + evento.getHora());
        horaLabel.setBounds(15, 60, 300, 50);
        horaLabel.setForeground(new Color(255, 255, 255));
        horaLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        dataLabel.setText("Data: " + evento.getData());
        dataLabel.setBounds(15, 75, 300, 50);
        dataLabel.setForeground(new Color(255, 255, 255));
        dataLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        descricaoLabel.setText("Descrição: " + evento.getDescricao());
        descricaoLabel.setBounds(15, 90, 300, 50);
        descricaoLabel.setForeground(new Color(255, 255, 255));
        descricaoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        painel.setBounds(5, 5, 275, 255);

        deletar.setBounds(95, 275, 100, 50);
        deletar.setText("Deletar");
        deletar.setForeground(new Color(255, 255, 255));
        deletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = evento.getId();
                System.out.println(id);
                Delete deletar = new Delete();
                deletar.deletarEvento(id);
                visualAdmin.frameDispose();
                VisualAdmin v = new VisualAdmin();
                framePrincipal.dispose();
            }
        });

        framePrincipal.add(nomeClienteLabel);
        framePrincipal.add(tipoEventoLabel);
        framePrincipal.add(localLabel);
        framePrincipal.add(horaLabel);
        framePrincipal.add(dataLabel);
        framePrincipal.add(descricaoLabel);
        framePrincipal.add(deletar);
        framePrincipal.add(painel);
        framePrincipal.setLayout(null);

    }

    public void setVisualAdimin(VisualAdmin visualAdmin) {
        this.visualAdmin = visualAdmin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
