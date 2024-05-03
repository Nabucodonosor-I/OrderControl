package com.ordercontrol;

import Conexao.ConnectionFactory;

public class Main {
    public static void main(String[] args) {

        // Invoando construtores
        TelaCadastroLogin sp = new TelaCadastroLogin();
        ConnectionFactory cn = new ConnectionFactory();

        cn.obtemConexao();
        sp.getTextUsuario();
        sp.getPassword();
    }
}
