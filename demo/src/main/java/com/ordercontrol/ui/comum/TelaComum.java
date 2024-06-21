package com.ordercontrol.ui.comum;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.*;

import com.ordercontrol.DAO.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;
import com.ordercontrol.ui.ModeloTela;

import com.ordercontrol.ui.TelaPrincipal;
import com.ordercontrol.ui.administrador.AddEvento;

public class TelaComum extends ModeloTela implements AdjustmentListener {

    private final JLabel principalLabel = new JLabel();
    private final JLabel orderConttrl = new JLabel();
    private final RoundedPanel panel1 = new RoundedPanel(10, AZUL);
    private final RoundedPanel panel2 = new RoundedPanel(10, BRANCO);
    public final RoundedButton logout = new RoundedButton(20, CINZA, null);
    private final JScrollBar scrollBar = new JScrollBar();
    private final RoundedPanel painelBranco = new RoundedPanel(5, BRANCO);
    protected final RoundedButton addButton = new RoundedButton(20, CINZA, null);

    private Usuario usuario = null;
    private final EventoDAO eventoDAO = new EventoDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();


    private ArrayList<RoundedPanel> panels = new ArrayList<>();
    private ArrayList<Integer> originalYPositions = new ArrayList<>();
    private ArrayList<Evento> listaEventos = new ArrayList<>();
    private ArrayList<JLabel> labels = new ArrayList<>();

    int x = 30;
    int y = 150;
    int panelWidth = 215;
    int panelHeight = 195;
    int spacing = 15;
    int acumulador = 0;
    int acumuladorID = 1;
    Boolean adm;

    public TelaComum(TelaPrincipal telaPrincipal) {
        super(750, 600);
        this.usuario = usuarioDAO.lerUsuario(telaPrincipal.getTextUsuario(), telaPrincipal.getPassword());
        configureComponents();
        addComponentsToFrame();
        mostrarEventos(eventoDAO);
        setLayout(null);
    }

    public TelaComum(TelaPrincipal telaPrincipal, Boolean adm) {
        super(750, 600);
        this.adm = adm;
        this.usuario = usuarioDAO.lerUsuario(telaPrincipal.getTextUsuario(), telaPrincipal.getPassword());
        configureComponents();
        addComponentsToFrame();
        mostrarEventos(eventoDAO);
        setLayout(null);
    }

    private void configureComponents() {
        configLabels();
        configButtons();
        configPanels();
        configScrollBar();
    }

    private void configLabels() {
        configPrincipalLabel(principalLabel, 25, 25, 90, 90, 90, 90);
        configLabel(orderConttrl, "OrderControl", PRETO, BAUHAUS, 135, 50, 300, 40);
    }

    private void configButtons() {
        configButton(addButton, "Novo Evento", 340, 35, 140, 70, DEJAVU_19, BRANCO, CINZA);
        configButton(logout, "sair", 540, 35, 140, 70, DEJAVU_19, BRANCO, CINZA);
        addButton.addActionListener(this);
        logout.addActionListener(this);
    }

    private void configPanels() {
        panel1.setBounds(15, 15, 695, 110);
        panel2.setBounds(20, 20, 685, 100);
        painelBranco.setBounds(0, 0, 750, 150);
    }

    private void configScrollBar() {
        scrollBar.setBounds(717, 130, 15, 425);
        scrollBar.setForeground(CINZA);
        scrollBar.setBackground(AZUL);
        scrollBar.setMinimum(0);
        scrollBar.setMaximum(1000);
        scrollBar.addAdjustmentListener(this);
    }

    private void addComponentsToFrame() {
        if (adm == true) {
            add(addButton);
        }
        add(principalLabel);
        add(orderConttrl);
        add(logout);
        add(scrollBar);
        add(panel2);
        add(panel1);
        add(painelBranco);
    }

    public void mostrarEventos(EventoDAO read) {

        for (RoundedPanel panel : panels) {
            remove(panel);
        }
        panels.clear();
        originalYPositions.clear();
        labels.clear();

        listaEventos = read.listarEventos();

        for (Evento evento : listaEventos) {
            RoundedPanel eventoPanel = createEventoPanel(evento, x, y, panelWidth, panelHeight, acumuladorID);
            panels.add(eventoPanel);
            originalYPositions.add(y);
            add(eventoPanel);

            acumulador++;
            acumuladorID++;
            x += panelWidth + spacing;
            if (acumulador % 3 == 0) {
                x = 30;
                y += panelHeight + spacing;
            }
        }
    }

    private RoundedPanel createEventoPanel(Evento evento, int x, int y, int width, int height, int id) {
        RoundedPanel panel = new RoundedPanel(10, AZUL);
        panel.setLayout(null);
        panel.setBounds(x, y, width, height);

        JLabel nomeClienteLabel = createEventoLabel("Cliente: " + evento.getNomeCliente(), 5, 15, width - 10, 20);
        JLabel tipoEventoLabel = createEventoLabel("Tipo: " + evento.getTipoEventoToString(), 5, 35, width - 10, 20);
        JLabel localLabel = createEventoLabel("Local: " + evento.getLocal(), 5, 55, width - 10, 20);
        JLabel horaLabel = createEventoLabel("Hora: " + evento.getHora(), 5, 75, width - 10, 20);
        JLabel dataLabel = createEventoLabel("Data: " + evento.getData(), 5, 95, width - 10, 20);
        JLabel descricaoLabel = createEventoLabel("Descrição: " + evento.getDescricao(), 5, 115, width - 10, 20);

        RoundedButton detalhesButton = new RoundedButton(15, BRANCO, null);
        detalhesButton.setText("Detalhes");
        detalhesButton.setForeground(PRETO);
        detalhesButton.setBounds(55, 150, 100, 30);
        detalhesButton.setFocusable(false);
        detalhesButton.addActionListener(this);
        detalhesButton.setActionCommand("detalhes_" + id);

        panel.add(nomeClienteLabel);
        panel.add(tipoEventoLabel);
        panel.add(localLabel);
        panel.add(horaLabel);
        panel.add(dataLabel);
        panel.add(descricaoLabel);
        panel.add(detalhesButton);

        return panel;
    }

    public void frameDispose() {
        dispose();
    }

    public void addComponent(Component component) {
        add(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof RoundedButton) {
            RoundedButton button = (RoundedButton) source;
            if (button.getActionCommand().startsWith("detalhes_")) {
                detalhesButton(button);
            }
        } else if (source == logout) {
            logoutButton();
        } else if (source == addButton) {
            new AddEvento(this);
        }
    }

    protected void detalhesButton(RoundedButton button) {
        String indexString = button.getActionCommand().substring(9);
        int eventoIndex = Integer.parseInt(indexString);
        Evento evento = listaEventos.get(eventoIndex - 1);
        if (evento != null) {
            DetahlesComum detalhesComum = new DetahlesComum(evento, adm);
            detalhesComum.setUsuario(usuario);
            detalhesComum.setVisualComum(this);
        }
    }

    private void logoutButton() {
        dispose();
        new TelaPrincipal();
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        int value = scrollBar.getValue();
        for (int i = 0; i < panels.size(); i++) {
            RoundedPanel panel = panels.get(i);
            int originalY = originalYPositions.get(i);
            panel.setBounds(panel.getX(), originalY - value, panel.getWidth(), panel.getHeight());
        }
        repaint();
    }
}
