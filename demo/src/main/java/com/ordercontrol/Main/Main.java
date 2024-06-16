package com.ordercontrol.Main;

import javax.swing.SwingUtilities;
import com.ordercontrol.ui.TelaPrincipal;




public class Main {
    public static void main(String[] args) {   
        SwingUtilities.invokeLater(() -> {    

        // Invocando construtores
        TelaPrincipal sp = new TelaPrincipal();

        });
    }
}
