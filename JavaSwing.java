import java.awt.Color;
import javax.swing.*;

public class JavaSwing {
    public static void main(String[] args) {

        // Invoando construtores
        JFrame frame = new JFrame();
        JButton button1 = new JButton("Login");
        JButton button2 = new JButton("Cadastro");
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        ImageIcon imageIcon = new ImageIcon("68386.png");

        //configurações do frame
        frame.setSize(500,500);
        frame.setTitle("Mega Fibra OS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
        frame.setIconImage(imageIcon.getImage());
        frame.getContentPane().setBackground(new Color(0,139,139));

        //configuração botao
        button1.setBounds(175, 200, 150, 50);
        button2.setBounds(175, 300, 150, 50);

        //configurações label
        label1.setText("Bem vindo");
        label1.setBounds(175, 100, 200, 100);
        label1.setForeground(new Color(255,0,0));
        label2.setText("Mega Fibra OS");
        label2.setBounds(175, 50, 200, 100);
        label2.setForeground(new Color(255,0,0));
        

        // adiionado 
        frame.add(button1);
        frame.add(button2);
        frame.add(label1);
        frame.add(label2);
        
    }
}
