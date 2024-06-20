package com.ordercontrol.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ordercontrol.componentes.BordaCantoArredondado;
import com.ordercontrol.componentes.CustomRadioButton;
import com.ordercontrol.componentes.RoundedButton;

public class ModeloTela extends JFrame implements ActionListener {
    // Fonts
    protected static Font ARIAL_15 = new Font("Arial", Font.BOLD, 15);
    protected static Font ARIAL_16 = new Font("Arial", Font.BOLD, 16);
    protected static Font ARIAL_25 = new Font("Arial", Font.BOLD, 25);
    protected static Font ARIAL_13 = new Font("Arial", Font.BOLD, 13);
    protected static Font ARIAL_12 = new Font("Arial", Font.BOLD, 12);
    protected static Font DEJAVU_25 = new Font("DejaVu Sans Mono", Font.PLAIN, 25);
    protected static Font DEJAVU_19 = new Font("DejaVu Sans Mono", Font.PLAIN, 19);
    protected static Font DEJAVU_15 = new Font("DejaVu Sans Mono", Font.BOLD, 15);
    protected static Font DEJAVU_13 = new Font("DejaVu Sans Mono", Font.BOLD, 13);
    protected static Font BAUHAUS = new Font("Bauhaus 93", Font.PLAIN, 30);

    // Cores
    protected static Color BRANCO = new Color(255, 255, 255);
    protected static Color PRETO = new Color(0, 0, 0);
    protected static Color AZUL = new Color(28, 35, 43);
    protected static Color CINZA = new Color(54, 54, 54);
    protected static Color VERMELHO = new Color(255, 0, 0);

    protected static final BordaCantoArredondado BCA = new BordaCantoArredondado(PRETO, 2, 10);

    // Diretorio
    static final String CURRENT_DIRECTORY = System.getProperty("user.dir");

    // imageIcon
    static final ImageIcon imageIcon1 = new ImageIcon(
            CURRENT_DIRECTORY + "\\demo\\src\\main\\resources\\Imagens\\68386.png");

    public ImageIcon scaleImage(int width, int height) {

        final ImageIcon imageIcon2 = new ImageIcon(
                new ImageIcon(
                        CURRENT_DIRECTORY + "\\demo\\src\\main\\resources\\Imagens\\Logo.png")
                        .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

        return imageIcon2;
    }

    // Construtor
    public ModeloTela(int x, int y) {
        setSize(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Order Control");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BRANCO);
        setIconImage(imageIcon1.getImage());
    }

    public ModeloTela(int x, int y, int closeOperation) {
        setSize(x, y);
        setDefaultCloseOperation(closeOperation);
        setTitle("Order Control");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BRANCO);
        setIconImage(imageIcon1.getImage());
    }

    public void configRadioButton(CustomRadioButton radioButton, int x, int y, int width, int height) {
        radioButton.setBounds(x, y, width, height);
        radioButton.setOpaque(false);
    }

    public void configTextField(JTextField textField, int x, int y, int width, int height, int alignment,
            BordaCantoArredondado border) {
        textField.setBounds(x, y, width, height);
        textField.setHorizontalAlignment(alignment);
        textField.setBorder(border);
    }

    public void configLabel(JLabel label, String text, Color color, Font font, int x, int y, int width,
            int height) {
        label.setText(text);
        label.setForeground(color);
        label.setFont(font);
        label.setBounds(x, y, width, height);
    }

    public void configLabel(JLabel label, String text, Color color, int fontSize, int x, int y, int width,
            int height) {
        label.setText(text);
        label.setForeground(color);
        label.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, fontSize));
        label.setBounds(x, y, width, height);
    }

    public JLabel createEventoLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setForeground(BRANCO);
        label.setFont(DEJAVU_15);
        label.setBounds(x, y, width, height);
        return label;
    }

    public void configButton(RoundedButton button, String text, int x, int y, int width, int height) {
        button.setText(text);
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        button.setFont(DEJAVU_25);
        button.setForeground(BRANCO);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.addActionListener(this);
    }

    public void configButton(RoundedButton button, ImageIcon icon, int x, int y, int width, int height) {
        button.setIcon(icon);
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.addActionListener(this);
    }

    public void configButton(RoundedButton button, String text, int x, int y, int width, int height, Font font,
            Color foreground, Color background) {
        button.setText(text);
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        button.setFont(font);
        button.setForeground(foreground);
        button.setBackground(background);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.addActionListener(this);
    }

    public void configPrincipalLabel(JLabel label, int x, int y, int widthScale, int heightScale) {
        label.setBounds(x, y, 200, 200);
        label.setIcon(scaleImage(widthScale, heightScale));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    public void configPrincipalLabel(JLabel label, int x, int y, int width, int height, int widthScale,
            int heightScale) {
        label.setBounds(x, y, width, height);
        label.setIcon(scaleImage(widthScale, heightScale));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
