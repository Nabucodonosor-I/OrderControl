import javax.swing.*;
//import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroLogin extends JFrame implements ActionListener {
    JFrame framePrincipal = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton cadastroButton = new JButton("Cadastrar");
    JLabel principalLabel = new JLabel();
    ImageIcon imageIcon1 = new ImageIcon("68386.png");
    ImageIcon imageIcon2 = new ImageIcon("provedor-de-internet-2-43-1693542501.png");
    // Border border = BorderFactory.createLineBorder(Color.RED,1);

    TelaCadastroLogin() {

        // configurações frame
        framePrincipal.setSize(500, 500);
        framePrincipal.setTitle("Mega Fibra OS");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setResizable(false);
        framePrincipal.setVisible(true);
        framePrincipal.getContentPane().setBackground(new Color(255, 222, 173));
        framePrincipal.setIconImage(imageIcon1.getImage());

        // configuração botao login
        loginButton.setBounds(175, 250, 150, 50);
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(54, 54, 54));
        loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
        loginButton.addActionListener(this);
        // loginButton.addActionListener(e -> System.out.println("foi"));

        // configuração botão cadastro
        cadastroButton.setBounds(175, 350, 150, 50);
        cadastroButton.setFocusable(false);
        cadastroButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        cadastroButton.setForeground(new Color(255, 255, 255));
        cadastroButton.setBackground(new Color(54, 54, 54));
        cadastroButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cadastroButton.addActionListener(this);
        // cadastroButton.addActionListener(e -> System.out.println("foi2"));

        // configurações label
        principalLabel.setText("Mega Fibra OS");
        principalLabel.setBounds(150, 25, 200, 200);
        principalLabel.setForeground(new Color(255, 0, 0));
        principalLabel.setFont(new Font("MV Boli", Font.BOLD, 25));
        principalLabel.setIcon(imageIcon2);
        principalLabel.setHorizontalTextPosition(JLabel.CENTER);
        principalLabel.setVerticalTextPosition(JLabel.BOTTOM);
        principalLabel.setIconTextGap(-70);
        principalLabel.setVerticalAlignment(JLabel.CENTER);
        principalLabel.setHorizontalAlignment(JLabel.CENTER);
        // principalLabel.setBorder(border);

        // adicionado
        framePrincipal.add(principalLabel);
        framePrincipal.add(loginButton);
        framePrincipal.add(cadastroButton);
        framePrincipal.setLayout(null);
    }

    // acionamento do botão login

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == loginButton) {
            framePrincipal.dispose();
            Login login = new Login();
        } else if (o == cadastroButton) {
            framePrincipal.dispose();
            Cadastro cadastro = new Cadastro();
        }
    }
}
