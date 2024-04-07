import javax.swing.*;
//import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroLogin extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JFrame myFrame = new JFrame();

    TelaCadastroLogin() {

        // Invoando construtores
        JLabel label2 = new JLabel();
        button1 = new JButton("Login");
        button2 = new JButton("Cadastrar");
        ImageIcon imageIcon1 = new ImageIcon("68386.png");
        ImageIcon imageIcon2 = new ImageIcon("provedor-de-internet-2-43-1693542501.png");
        //Border border = BorderFactory.createLineBorder(Color.RED,1);

        // configurações frame
        myFrame.setSize(500, 500);
        myFrame.setTitle("Mega Fibra OS");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        myFrame.getContentPane().setBackground(new Color(255, 222, 173));

        // configuraçõs icones
        myFrame.setIconImage(imageIcon1.getImage());
        
        // configuração botao
        button1.setBounds(175, 250, 150, 50);
        button2.setBounds(175, 350, 150, 50);
        button1.setFocusable(false);
        button2.setFocusable(false);
        button1.setFont(new Font("DejaVu Sans Mono",Font.PLAIN,25));
        button2.setFont(new Font("DejaVu Sans Mono",Font.PLAIN,25));
        button1.setForeground(new Color(255,255,255));
        button2.setForeground(new Color(255,255,255));
        button1.setBackground(new Color(54,54,54));
        button2.setBackground(new Color(54,54,54));
        button1.setBorder(BorderFactory.createRaisedBevelBorder());
        button2.setBorder(BorderFactory.createRaisedBevelBorder());
        //button1.addActionListener(e -> System.out.println("foi"));
        button2.addActionListener(e -> System.out.println("foi2"));
        button1.addActionListener(this);

        // configurações label
        label2.setText("Mega Fibra OS");
        label2.setBounds(150, 25, 200, 200);
        label2.setForeground(new Color(255, 0, 0));
        label2.setFont(new Font("MV Boli", Font.BOLD, 25));
        label2.setIcon(imageIcon2);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);
        label2.setIconTextGap(-70);
        //label2.setBorder(border);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);

        // adicionado
        myFrame.add(label2);
        myFrame.add(button1);
        myFrame.add(button2);
        myFrame.setLayout(getLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1) {
            myFrame.dispose();
            Login login = new Login();
            //return true;
        }
        //return false;   
    }

    
}
