package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConnectionFactory;
import Conexao.Usuario;

public class Create {
    public void criarUsuario() {
        String sql = "INSERT INTO  tb_cadastro(nome, senha, email, cpf, sexo, idade, admin) VALUES(?, ?, ?, ?, ?, ?, ?)";

        ConnectionFactory factory = new ConnectionFactory();
        
        try (Connection c = factory.obtemConexao()) {
           PreparedStatement ps = c.prepareStatement(sql);
           ps.setString(1, Usuario.getNome());
           ps.setString(2, Usuario.getSenha());
           ps.setString(3, Usuario.getEmail());
           ps.setInt(4, Usuario.getCpf());
           ps.setString(5, Usuario.getSexo());
           ps.setInt(6, Usuario.getIdade());
           ps.setString(7, Usuario.getAdmin());
           ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}