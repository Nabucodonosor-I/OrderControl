package com.ordercontrol.componentes;

import java.awt.*;
import javax.swing.border.AbstractBorder;

/**
 * https://www.guj.com.br/t/bordas-arredondadas-em-java/422941/2
 * 
 * agradeimento ao 
 * @author David Buzatto 
 */

public class BordaCantoArredondado extends AbstractBorder {

    private int red;
    private int green;
    private int blue;
    private float strokeWidth;
    private int cornerRadius;
  
    public BordaCantoArredondado(int red, int green, int blue, float strokeWidth, int cornerRadius) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.strokeWidth = strokeWidth;
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(red, green, blue));
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawRoundRect(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
        g2d.dispose();
    }
}
