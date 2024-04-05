import javax.swing.*;
import java.awt.Color;

public class MyFrame extends JFrame {
    MyFrame() {
        
        // Invoando construtores
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JButton button1 = new JButton("Login");
        JButton button2 = new JButton("Cadastro");
        ImageIcon imageIcon1 = new ImageIcon("68386.png");
        ImageIcon imageIcon2 = new ImageIcon("68386.png");

        //configurações frame
        this.setSize(500, 500);
        this.setTitle("Mega Fibra OS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        //configuraçõs icones
        this.setIconImage(imageIcon1.getImage());
        this.getContentPane().setBackground(new Color(0, 139, 139));

        // configuração botao
        button1.setBounds(175, 200, 150, 50);
        button2.setBounds(175, 300, 150, 50);

        //configurações label
        label1.setText("Bem vindo");
        label1.setBounds(175, 100, 200, 100);
        label1.setForeground(new Color(255, 0, 0));
        label2.setText("Mega Fibra OS");
        label2.setBounds(175, 50, 200, 100);
        label2.setForeground(new Color(255, 0, 0));

        // adicionado 
        add(label1);
        add(label2);

    }
}
