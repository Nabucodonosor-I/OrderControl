package com.ordercontrol.componentes;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RoundedPanel extends JPanel {
    private int cornerRadius;
    private Color backgroundColor;

    public RoundedPanel(int cornerRadius, Color backgroundColor) {
        this.cornerRadius = cornerRadius;
        this.backgroundColor = backgroundColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        g2.dispose();
        super.paintComponent(g);
    }
}