import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroLogin extends JFrame implements ActionListener {
    JFrame framePrincipal = new JFrame();
    RoundedButton loginButton = new RoundedButton(10, new Color(54, 54, 54));
    RoundedButton cadastroButton = new RoundedButton(10, new Color(54, 54, 54));
    JButton exitButton = new JButton("x");
    JLabel principalLabel = new JLabel();
    RoundedPanel painel = new RoundedPanel(20, new Color(28, 35, 43));
    ImageIcon imageIcon1 = new ImageIcon("Imagens\\68386.png");
    ImageIcon imageIcon2 = new ImageIcon(
            new ImageIcon("Imagens\\Logo.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    // Border border = BorderFactory.createLineBorder(Color.RED,1);

    JTextField usuario = new JTextField();
    JPasswordField senha = new JPasswordField();
    JButton submit = new JButton("Enviar ");
    JLabel label = new JLabel();
    JLabel senhaLabel = new JLabel();
    JLabel usuarioLabel = new JLabel();
    JLabel bemVindo = new JLabel();
    JLabel credenciais = new JLabel();
    JLabel orderConttrl = new JLabel();

    public TelaCadastroLogin() {

        // configurações frame
        framePrincipal.setSize(750, 600);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setResizable(false);
        framePrincipal.setUndecorated(true);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.getContentPane().setBackground(new Color(255, 255, 255));
        framePrincipal.setIconImage(imageIcon1.getImage());
        
        // config painel
        painel.setBounds(15, 15, 350, 570);  

        // config text field usuario
        usuario.setBounds(470, 200, 200, 30);
        usuario.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // config text field senha
        senha.setBounds(470, 275, 200, 30);
        senha.setBorder(new BordaCantoArredondado(0, 0, 0, 2, 10));

        // configurações label senha
        senhaLabel.setText("Senha ");
        senhaLabel.setForeground(new Color(0, 0, 0));
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        senhaLabel.setBounds(470, 250, 125, 25);

        // configurações label usuario
        usuarioLabel.setText("Usuario ");
        usuarioLabel.setForeground(new Color(0, 0, 0));
        usuarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usuarioLabel.setBounds(470, 175, 125, 25);

        // onfig Label Bem vindo
        bemVindo.setText("Bem Vindo");
        bemVindo.setForeground(new Color(0, 0, 0));
        bemVindo.setFont(new Font("Arial", Font.BOLD, 25));
        bemVindo.setBounds(400, 40, 200, 30);

        // config label credenciais
        credenciais.setText("Insira suas Credenciais, por favor");
        credenciais.setForeground(new Color(0, 0, 0));
        credenciais.setFont(new Font("Arial", Font.BOLD, 13));
        credenciais.setBounds(400, 63, 300, 30);

        // config Label OrderControl
        orderConttrl.setText("OrderControl");
        orderConttrl.setForeground(new Color(255, 255, 255));
        orderConttrl.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        orderConttrl.setBounds(105, 240, 300, 40);

        // configuração botao login
        loginButton.setText("Login");
        loginButton.setBounds(470, 375, 200, 50);
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
        loginButton.addActionListener(this);

        // configuração botão cadastro
        cadastroButton.setText("Cadastrar");
        cadastroButton.setBounds(470, 450, 200, 50);
        cadastroButton.setFocusable(false);
        cadastroButton.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 25));
        cadastroButton.setForeground(new Color(255, 255, 255));
        cadastroButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cadastroButton.addActionListener(this);

        // onfiguração botão de saida
        exitButton.setBounds(705, 0, 45, 45);
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setForeground(new Color(0, 0, 0));
        exitButton.addActionListener(this);

        // configurações label
        principalLabel.setBounds(95, 35, 200, 200);
        principalLabel.setForeground(new Color(255, 0, 0));
        principalLabel.setFont(new Font("MV Boli", Font.BOLD, 25));
        principalLabel.setIcon(imageIcon2);
        principalLabel.setHorizontalTextPosition(JLabel.CENTER);
        principalLabel.setVerticalTextPosition(JLabel.BOTTOM);
        principalLabel.setIconTextGap(-70);
        principalLabel.setVerticalAlignment(JLabel.CENTER);
        principalLabel.setHorizontalAlignment(JLabel.CENTER);

        // adicionado
        framePrincipal.add(principalLabel);
        framePrincipal.add(loginButton);
        framePrincipal.add(cadastroButton);
        framePrincipal.add(exitButton);
        framePrincipal.add(usuario);
        framePrincipal.add(senha);
        framePrincipal.add(senhaLabel);
        framePrincipal.add(usuarioLabel);
        framePrincipal.add(bemVindo);
        framePrincipal.add(credenciais);
        framePrincipal.add(orderConttrl);
        framePrincipal.add(painel);
        framePrincipal.setLayout(null);
    }

    public String getSenha() {
        return senha.getText();
    }

    public String getUsuario() {
        return usuario.getText();
    }

    // acionamento do botão login

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == loginButton) {
            System.out.println(getUsuario());
            System.out.println(getSenha());
        } else if (o == cadastroButton) {
            framePrincipal.dispose();
            Cadastro cadastro = new Cadastro();
        } else if (o == exitButton) {
            framePrincipal.dispose();
        }
    }
}
