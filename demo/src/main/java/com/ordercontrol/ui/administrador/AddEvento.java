package com.ordercontrol.ui.administrador;

import javax.swing.*;

import com.ordercontrol.DAO.*;
import com.ordercontrol.componentes.*;
import com.ordercontrol.model.*;
import com.ordercontrol.ui.ModeloTela;
import com.ordercontrol.ui.TelaPrincipal;
import com.ordercontrol.ui.comum.TelaComum;

import java.awt.event.ActionEvent;

public class AddEvento extends ModeloTela {

    private final JFrame framePrincipal = new JFrame();
    private final RoundedButton cadastroButton = new RoundedButton(10, CINZA, null);
    private final CustomRadioButton ordemServ = new CustomRadioButton(PRETO);
    private final CustomRadioButton orcam = new CustomRadioButton(PRETO);
    private final ButtonGroup group = new ButtonGroup();
    private final RoundedPanel painel = new RoundedPanel(20, AZUL);
    private final RoundedPanel painel2 = new RoundedPanel(20, BRANCO);
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
    private TelaComum admin = null;

    public AddEvento(TelaComum telaComum) {
        super(750, 600, 2);
        this.admin = telaComum;
        initializeComponents();
        addComponentsToFrame();
        setLayout(null);
    }

    private void initializeComponents() {
        configurePanels();
        configureTextFields();
        configureLabels();
        configureButtons();
        configureRadioButtons();
    }

    private void configurePanels() {
        painel.setBounds(15, 15, 705, 530);
        painel2.setBounds(25, 25, 685, 510);
    }

    private void configureTextFields() {
        configTextField(cliente, 85, 115, 210, 30, SwingConstants.CENTER, BCA);
        configTextField(local, 425, 115, 210, 30, SwingConstants.CENTER, BCA);
        configTextField(data, 425, 190, 210, 30, SwingConstants.CENTER, BCA);
        configTextField(descricao, 85, 190, 210, 150, SwingConstants.CENTER, BCA);
        configTextField(hora, 425, 265, 100, 30, SwingConstants.CENTER, BCA);
    }

    private void configureLabels() {
        configLabel(descricaoLabel, "Descrição ", PRETO, ARIAL_15, 85, 165, 125, 25);
        configLabel(clienteLabel, "Nome do cliente ", PRETO, ARIAL_15, 85, 90, 125, 25);
        configLabel(localLabel, "Local do Evento ", PRETO, ARIAL_15, 425, 90, 125, 25);
        configLabel(dataLabel, "Data do evento", PRETO, ARIAL_15, 425, 165, 125, 25);
        configLabel(horaLabel, "Hora do evento", PRETO, ARIAL_15, 425, 240, 125, 25);
        configLabel(ordemServLabel, "Ordem de serviço ", PRETO, ARIAL_15, 520, 320, 125, 25);
        configLabel(orcanLabel, "Orçamento ", PRETO, ARIAL_15, 420, 320, 125, 25);
        configLabel(orderConttrl, "OrderControl", PRETO, BAUHAUS, 260, 35, 200, 50);
    }

    private void configureButtons() {
        configButton(cadastroButton, "Cadastrar", 250, 400, 200, 50);
    }

    private void configureRadioButtons() {
        configRadioButton(ordemServ, 500, 320, 20, 20);
        configRadioButton(orcam, 400, 320, 20, 20);
        group.add(ordemServ);
        group.add(orcam);
    }

    private void addComponentsToFrame() {
        add(cliente);
        add(local);
        add(data);
        add(descricao);
        add(hora);
        add(descricaoLabel);
        add(clienteLabel);
        add(localLabel);
        add(dataLabel);
        add(ordemServLabel);
        add(orcanLabel);
        add(orderConttrl);
        add(horaLabel);
        add(cadastroButton);
        add(ordemServ);
        add(orcam);
        add(painel2);
        add(painel);
    }

    public int tipoEvento() {
        if (ordemServ.isSelected()) {
            return 0;
        } else if (orcam.isSelected()) {
            return 1;
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastroButton) {
            cadastrarEvento();
        }
    }

    private void cadastrarEvento() {
        Evento evento = new Evento(
                tipoEvento(),
                cliente.getText(),
                local.getText(),
                data.getText(),
                hora.getText(),
                descricao.getText());

        EventoDAO eventoDAO = new EventoDAO();
        boolean criarEvento = eventoDAO.criarEvento(evento);

        if (criarEvento) {
            JOptionPane.showMessageDialog(null, "Evento cadastrado");
            admin.frameDispose();
            TelaComum visualAdmin = new TelaComum(new TelaPrincipal());
            visualAdmin.mostrarEventos(new EventoDAO());
            framePrincipal.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar evento");
        }
    }
}
