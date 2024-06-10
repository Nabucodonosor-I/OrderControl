package com.ordercontrol.componentes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;

public class RoundedButton extends JButton {
    private int cornerRadius;
    private Color backgroundColor;
    private Color borderColor;
    private float espessuraLinha = 2.0f;

    public RoundedButton(int cornerRadius, Color backgroundColor, Color borderColor) {
        this.cornerRadius = cornerRadius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    public void setEspessuraLinha(float espessuraLinha) {
        this.espessuraLinha = espessuraLinha;
        repaint();
    }

    public void setNewColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g);

        g2.setStroke(new BasicStroke(espessuraLinha));
        g2.setColor(borderColor);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        
        g2.dispose();
    }
}