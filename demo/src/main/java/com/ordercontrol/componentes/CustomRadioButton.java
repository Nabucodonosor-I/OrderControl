package com.ordercontrol.componentes;

import javax.swing.*;
import java.awt.*;

public class CustomRadioButton extends JRadioButton {
    private Color Color;

    public CustomRadioButton( Color Color) {
        this.Color = Color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        float espessuraLinha = 2.0f; 
        g2.setStroke(new BasicStroke(espessuraLinha));
        
        // Obtem as dimensões do JRadioButton
        int buttonSize = getHeight(); 
        int diameter = buttonSize / 2; 
        
        // Calcula a posição do círculo
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        if (isSelected()) {
            // Defini a cor desejada para o círculo selecionado
            g2.setColor(new Color(255,0,0));
            // Desenha o círculo preenchido
            g2.fillOval(x, y, diameter, diameter);
            
        } else {
            // Defini uma cor para o estado não selecionado
            g2.setColor(Color);
            // Desenha um círculo de contorno
            g2.drawOval(x, y, diameter, diameter);
        }
        g2.dispose();
    }
    
}
