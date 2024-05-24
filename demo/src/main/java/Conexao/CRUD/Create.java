package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConnectionFactory;
import Conexao.Usuario;

public class Create {
    Usuario usuario = new Usuario();
    public void criarUsuario() {
        String sql = "INSERT INTO  tb_cadastro(nome, senha, email, cpf, sexo, idade, admin) VALUES(?, ?, ?, ?, ?, ?, ?)";

        ConnectionFactory factory = new ConnectionFactory();
        
        try (Connection c = factory.obtemConexao()) {
           PreparedStatement ps = c.prepareStatement(sql);
           ps.setString(1, usuario.getNome());
           ps.setString(2, usuario.getSenha());
           ps.setString(3, usuario.getEmail());
           ps.setInt(4, usuario.getCpf());
           ps.setString(5, usuario.getSexo());
           ps.setInt(6, usuario.getIdade());
           ps.setString(7, usuario.getAdmin());
           ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}