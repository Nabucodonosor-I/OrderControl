import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
// import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {
    JFrame frameLogin = new JFrame();
    JTextField usuario = new JTextField();
    JPasswordField senha = new JPasswordField();
    JButton submit = new JButton("Enviar ");
    JLabel label = new JLabel();
    JLabel senhaLabel = new JLabel();
    JLabel usuarioLabel = new JLabel();
    ImageIcon imageIcon2 = new ImageIcon("provedor-de-internet-2-43-1693542501.png");
    // Border border = BorderFactory.createLineBorder(Color.RED,1);

    Login() {
        // configuração do frame
        frameLogin.setSize(500, 500);
        frameLogin.setTitle("Mega Fibra OS   Login");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setResizable(false);
        frameLogin.setVisible(true);
        frameLogin.setLayout(null);
        frameLogin.getContentPane().setBackground(new Color(255, 222, 173));

        // configuração textField usuario
        usuario.setBounds(210, 230, 115, 25);

        // onfiguração PasswordField senha
        senha.setBounds(210, 275, 115, 25);

        // configuração do botão enviar
        submit.setBounds(175, 350, 150, 50);
        submit.addActionListener(this);

        // configurações label Principal
        label.setText("Mega Fibra OS");
        label.setBounds(150, 20, 200, 200);
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("MV Boli", Font.BOLD, 25));
        label.setIcon(imageIcon2);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setIconTextGap(-70);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        // label.setBorder(border);

        // configurações label senha
        senhaLabel.setText("Senha: ");
        senhaLabel.setBounds(155, 275, 125, 25);

        // configurações label usuario
        usuarioLabel.setText("Usuario: ");
        usuarioLabel.setBounds(155, 230, 125, 25);

        // adicionando
        frameLogin.add(senhaLabel);
        frameLogin.add(senha);
        frameLogin.add(label);
        frameLogin.add(usuario);
        frameLogin.add(usuarioLabel);
        frameLogin.add(submit);

    }

    public String getSenha() {
        return senha.getText();
    }

    public String getUsuario() {
        return usuario.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            getUsuario();
            getSenha();
        }
    }

}
