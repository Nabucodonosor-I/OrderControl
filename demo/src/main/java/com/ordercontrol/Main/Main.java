package com.ordercontrol.Main;

import javax.swing.SwingUtilities;

import com.ordercontrol.DAO.ConnectionFactory;
import com.ordercontrol.DAO.CRUD.ValidarUsuario;
import com.ordercontrol.ui.TelaPrincipal;




public class Main {
    public static void main(String[] args) {   
        SwingUtilities.invokeLater(() -> {    

        // Invoando construtores
        TelaPrincipal sp = new TelaPrincipal();
        ConnectionFactory cn = new ConnectionFactory();
        ValidarUsuario vu = new ValidarUsuario();

        
        cn.obtemConexao();
        sp.getTextUsuario();
        sp.getPassword();
        });
    }
}
