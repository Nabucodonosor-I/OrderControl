package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ordercontrol.TelaCadastroLogin;

import Conexao.ConnectionFactory;

public class ValidarUsuario {
    public int lerUsuario(String digtUsuario, String digtSenha) {

        TelaCadastroLogin login = new TelaCadastroLogin();


        int idValidUsuario = 0;

        // 1: Definir o comando SQL
        String sql = "SELECT * FROM tb_cadastro WHERE email = ? and senha = ?";
        System.out.println(sql);

        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, digtUsuario);
            ps.setNString(2, digtSenha);

            // 4: Executa o comando e guarda o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);

            if (rs.next()) {
                idValidUsuario = rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idValidUsuario;
    }
}