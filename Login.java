import javax.swing.JFrame;
import java.awt.Color;

public class Login {
    JFrame frameLogin = new JFrame();

    Login(){
        frameLogin.setSize(500, 500);
        frameLogin.setTitle("Mega Fibra OS");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setResizable(false);
        frameLogin.setVisible(true);
        frameLogin.getContentPane().setBackground(new Color(255, 222, 173));
    }
}
