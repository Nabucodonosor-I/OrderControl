package com.ordercontrol;

import javax.swing.SwingUtilities;

import com.ordercontrol.Interface.TelaCadastroLogin;

import Conexao.ConnectionFactory;
import Conexao.CRUD.ValidarUsuario;

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
