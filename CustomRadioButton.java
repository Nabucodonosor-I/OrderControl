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
        
        // Obter as dimensões do JRadioButton
        int buttonSize = getHeight(); 
        int diameter = buttonSize / 2; 
        
        // Calcular a posição do círculo
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        if (isSelected()) {
            // Definir a cor desejada para o círculo selecionado
            g2.setColor(Color);
            // Desenhar o círculo preenchido
            g2.fillOval(x, y, diameter, diameter);
        } else {
            // Definir uma cor para o estado não selecionado, se desejado
            g2.setColor(Color);
            // Desenhar um círculo de contorno
            g2.drawOval(x, y, diameter, diameter);
        }
        g2.dispose();
    }
    
}
