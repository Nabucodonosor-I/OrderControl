package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.ConnectionFactory;
import Conexao.Usuario;

public class ValidarUsuario {
    
    public Usuario lerUsuario(String digtUsuario, String digtSenha) {
        Usuario usuario = null;
        

        // 1: Definir o comando SQL
        String sql = "SELECT * FROM tb_cadastro WHERE email = ? and senha = ?";
        
        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, digtUsuario);
            ps.setString(2, digtSenha);
                        
            // 4: Executa o comando e guarda o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();   
            
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getInt("cpf"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setAdmin(rs.getInt("admin"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}