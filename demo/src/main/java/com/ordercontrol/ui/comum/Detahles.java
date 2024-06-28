package com.ordercontrol.ui.comum;

import javax.swing.*;
import java.awt.event.*;

import com.ordercontrol.DAO.EventoDAO;
import com.ordercontrol.DAO.UsuarioDAO;
import com.ordercontrol.componentes.RoundedButton;
import com.ordercontrol.componentes.RoundedPanel;
import com.ordercontrol.model.Evento;
import com.ordercontrol.model.Usuario;
import com.ordercontrol.ui.ModeloTela;
public class Detahles extends ModeloTela {

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
    private final RoundedPanel painel = new RoundedPanel(10, AZUL);
    private final RoundedButton registrar = new RoundedButton(10, CINZA, null);
    private final RoundedButton deletar = new RoundedButton(10, CINZA, null);

    private Usuario usuarioLogado = null;
    private Usuario usuario = new Usuario();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private TelaPrincipal telaPrincipal = null;

    boolean adm;

    public Detahles(Evento evento, Usuario usuarioLogado, Boolean adm) {
        super(580, 400, 2);
        this.usuarioLogado = usuarioLogado;
        this.adm = adm;
        configureLabels(evento);
        configurePanel();
        configButtons(evento);
        addComponentsToFrame();
        setLayout(null);
    }

    private void configureLabels(Evento evento) {
        configLabel(nomeClienteLabel, "Cliente: " + evento.getNomeCliente(), BRANCO, DEJAVU_15, 15, 15, 300, 50);
        configLabel(tipoEventoLabel, "Tipo: " + evento.getTipoEventoToString(), BRANCO, DEJAVU_15, 15, 35, 300, 50);
        configLabel(localLabel, "Local: " + evento.getLocal(), BRANCO, DEJAVU_15, 15, 55, 300, 50);
        configLabel(horaLabel, "Hora: " + evento.getHora(), BRANCO, DEJAVU_15, 15, 75, 300, 50);
        configLabel(dataLabel, "Data: " + evento.getData(), BRANCO, DEJAVU_15, 15, 95, 300, 50);
        configLabel(descricaoLabel, "Descrição: " + evento.getDescricao(), BRANCO, DEJAVU_15, 15, 115, 300, 50);
        configLabel(obs, "Quantidade máxima de inscritos: 2", PRETO, DEJAVU_13, 315, 225, 300, 50);
        configureUsuarioLabels(evento);
    }

    private void configurePanel() {
        painel.setBounds(5, 5, 290, 255);
    }

    private void configureUsuarioLabels(Evento evento) {
        int[] usuarios = evento.getUsuarios();
        if (usuarios[0] != 0) {
            usuario = usuarioDAO.getUsuarioById(usuarios[0]);
            configLabel(usuarioCadastrados, "Usuários inscritos:", PRETO, 18, 315, 15, 300, 50);
            configLabel(nomeUsuario1, "Nome: " + usuario.getNome(), PRETO, DEJAVU_15, 315, 45, 300, 50);
            configLabel(cpfUsuario1, "Cpf: " + usuario.getCpf(), PRETO, DEJAVU_15, 315, 65, 300, 50);
            if (usuarios[1] != 0) {
                usuario = usuarioDAO.getUsuarioById(usuarios[1]);
                configLabel(nomeUsuario2, "Nome: " + usuario.getNome(), PRETO, DEJAVU_15, 315, 95, 300, 50);
                configLabel(cpfUsuario2, "Cpf: " + usuario.getCpf(),PRETO, DEJAVU_15, 315, 115, 300, 50);
            }
        } else {
            configLabel(usuarioCadastrados, "Nenhum usuário registrado", PRETO, DEJAVU_15, 315, 15, 300, 50);
        }
    }

    private void configButtons(Evento evento) {
        if (adm == true) {
            registrar.setBounds(375, 280, 120, 50);
            deletar.setBounds(85, 280, 120, 50);
        }else {
            registrar.setBounds(230, 280, 120, 50);
        }
        registrar.setText("Inscrever-se");
        registrar.setForeground(BRANCO);
        registrar.setFocusable(false);
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarButton(evento);
            }
        });
        
        
        deletar.setText("Deletar");
        deletar.setForeground(BRANCO);
        deletar.setFocusable(false);
        deletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = evento.getId();
                System.out.println(id);
                EventoDAO deletar = new EventoDAO();
                deletar.deletarEvento(id);
                telaPrincipal.dispose();
                new TelaPrincipal(usuario, adm);
                dispose();
            }
        });
    }

    



    private void RegistrarButton(Evento evento) {
        EventoDAO update = new EventoDAO();
        if (update.inscreverUsuario(usuarioLogado.getId(), evento.getId())) {
            JOptionPane.showMessageDialog(null, "Seu registro no evento foi efetuado com sucesso!");
            dispose();
            if (telaPrincipal != null) {
                telaPrincipal = new TelaPrincipal(usuarioLogado, adm);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Evento já está com o número máximo de inscritos.");
        }
    }

    private void addComponentsToFrame() {
        if (adm == true) {
            add(deletar);
        }
        add(nomeClienteLabel);
        add(tipoEventoLabel);
        add(localLabel);
        add(horaLabel);
        add(dataLabel);
        add(descricaoLabel);
        add(registrar);
        add(obs);
        add(painel);
        add(usuarioCadastrados);
        add(nomeUsuario1);
        add(cpfUsuario1);
        add(nomeUsuario2);
        add(cpfUsuario2);
    }

    public void setVisualComum(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Method left intentionally empty
    }
}
