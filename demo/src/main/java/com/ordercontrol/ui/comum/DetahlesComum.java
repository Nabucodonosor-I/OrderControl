package com.ordercontrol.ui.comum;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.ordercontrol.DAO.CRUD.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;

public class DetahlesComum implements ActionListener {

    private final JFrame framePrincipal = new JFrame();
    private final String currentDirectory = System.getProperty("user.dir");
    private final ImageIcon imageIcon1 = new ImageIcon(
            currentDirectory + "\\demo\\src\\main\\resources\\Imagens\\68386.png");
    private final JLabel nomeClienteLabel = new JLabel();
    private final JLabel tipoEventoLabel = new JLabel();
    private final JLabel localLabel = new JLabel();
    private final JLabel horaLabel = new JLabel();
    private final JLabel dataLabel = new JLabel();
    private final JLabel descricaoLabel = new JLabel();
    private final JLabel usuarioCadastrados = new JLabel();
    private final JLabel nomeUsuario1 = new JLabel();
    private final JLabel nomeUsuario2 = new JLabel();
    private final JLabel cpfUsuario1 = new JLabel();
    private final JLabel cpfUsuario2 = new JLabel();
    private final JLabel obs = new JLabel();

    private final RoundedPanel painel = new RoundedPanel(10, new Color(28, 35, 43));
    private final RoundedButton registrar = new RoundedButton(10, new Color(54, 54, 54), null);

    Usuario usuario = null;
    Read read = new Read();
    TelaComum telaComum = null;

    DetahlesComum(Evento evento) {
        // configurações frame
        framePrincipal.setSize(600, 400);
        framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePrincipal.setResizable(false);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());

        nomeClienteLabel.setText("Cliente: " + evento.getNomeCliente());
        nomeClienteLabel.setBounds(15, 15, 300, 50);
        nomeClienteLabel.setForeground(new Color(255, 255, 255));
        nomeClienteLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        tipoEventoLabel.setText("Tipo: " + evento.getTipoEventoToString());
        tipoEventoLabel.setBounds(15, 35, 300, 50);
        tipoEventoLabel.setForeground(new Color(255, 255, 255));
        tipoEventoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        localLabel.setText("Local: " + evento.getLocal());
        localLabel.setBounds(15, 55, 300, 50);
        localLabel.setForeground(new Color(255, 255, 255));
        localLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        horaLabel.setText("Hora: " + evento.getHora());
        horaLabel.setBounds(15, 75, 300, 50);
        horaLabel.setForeground(new Color(255, 255, 255));
        horaLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        dataLabel.setText("Data: " + evento.getData());
        dataLabel.setBounds(15, 95, 300, 50);
        dataLabel.setForeground(new Color(255, 255, 255));
        dataLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        descricaoLabel.setText("Descrição: " + evento.getDescricao());
        descricaoLabel.setBounds(15, 115, 300, 50);
        descricaoLabel.setForeground(new Color(255, 255, 255));
        descricaoLabel.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

        painel.setBounds(5, 5, 290, 255);

        obs.setText("Quantidade maxima de inscritos: 2");
        obs.setBounds(315, 225, 300, 50);
        obs.setForeground(new Color(0, 0, 0));
        obs.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 13));

        int[] usuarios = evento.getUsuarios();

        if (usuarios[0] != 0) {
            usuario = read.getUsuarioById(usuarios[0]);

            usuarioCadastrados.setText("Usuarios inscritos: ");
            usuarioCadastrados.setBounds(315, 15, 300, 50);
            usuarioCadastrados.setForeground(new Color(0, 0, 0));
            usuarioCadastrados.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 18));

            nomeUsuario1.setText("Nome: " + usuario.getNome());
            nomeUsuario1.setBounds(315, 45, 300, 50);
            nomeUsuario1.setForeground(new Color(0, 0, 0));
            nomeUsuario1.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

            cpfUsuario1.setText("Cpf: " + usuario.getCpf());
            cpfUsuario1.setBounds(315, 65, 300, 50);
            cpfUsuario1.setForeground(new Color(0, 0, 0));
            cpfUsuario1.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

            framePrincipal.add(usuarioCadastrados);
            framePrincipal.add(nomeUsuario1);
            framePrincipal.add(cpfUsuario1);

            if (usuarios[1] != 0) {
                usuario = read.getUsuarioById(usuarios[1]);

                nomeUsuario2.setText("Nome: " + usuario.getNome());
                nomeUsuario2.setBounds(315, 95, 300, 50);
                nomeUsuario2.setForeground(new Color(0, 0, 0));
                nomeUsuario2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

                cpfUsuario2.setText("Cpf: " + usuario.getCpf());
                cpfUsuario2.setBounds(315, 115, 300, 50);
                cpfUsuario2.setForeground(new Color(0, 0, 0));
                cpfUsuario2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

                framePrincipal.add(nomeUsuario2);
                framePrincipal.add(cpfUsuario2);
            }
        } else {
            usuarioCadastrados.setText("Nenhum usuario registrado");
            usuarioCadastrados.setBounds(315, 15, 300, 50);
            usuarioCadastrados.setForeground(new Color(0, 0, 0));
            usuarioCadastrados.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

            framePrincipal.add(usuarioCadastrados);
        }

        registrar.setBounds(230, 280, 120, 50);
        registrar.setText("Inscrever-se");
        registrar.setForeground(new Color(255, 255, 255));
        registrar.setFocusable(false);
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update update = new Update();

                if (update.inscreverUsuario(usuario.getId(), evento.getId()) == true) {
                    JOptionPane.showMessageDialog(null, "Seu registro no evento foi efetuado com sucesso!");
                    framePrincipal.dispose();
                    telaComum.mostrarEventos(read);
                } else {
                    JOptionPane.showMessageDialog(null, "Evento já está com o número máximo de inscritos.");
                }
            }
        });

        framePrincipal.add(nomeClienteLabel);
        framePrincipal.add(tipoEventoLabel);
        framePrincipal.add(localLabel);
        framePrincipal.add(horaLabel);
        framePrincipal.add(dataLabel);
        framePrincipal.add(descricaoLabel);
        framePrincipal.add(registrar);
        framePrincipal.add(obs);
        framePrincipal.add(painel);
        framePrincipal.setLayout(null);

    }

    public void setVisualComum(TelaComum telaComum) {
        this.telaComum = telaComum;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
