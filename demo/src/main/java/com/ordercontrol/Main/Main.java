package com.ordercontrol.Main;

import javax.swing.SwingUtilities;

import com.ordercontrol.DAO.ConnectionFactory;
import com.ordercontrol.DAO.CRUD.ValidarUsuario;
import com.ordercontrol.ui.TelaCadastroLogin;




public class Main {
    public static void main(String[] args) {   
        SwingUtilities.invokeLater(() -> {    

        // Invoando construtores
        TelaCadastroLogin sp = new TelaCadastroLogin();
        ConnectionFactory cn = new ConnectionFactory();
        ValidarUsuario vu = new ValidarUsuario();

        
        cn.obtemConexao();
        sp.getTextUsuario();
        sp.getPassword();
        });
    }
}
