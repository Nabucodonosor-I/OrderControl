package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConnectionFactory;
import Conexao.Usuario;

public class Update {
    public void atualizarUsuario() {
        Usuario usuario = new Usuario();
        // 1: Definir o comando SQL
        String sql = "UPDATE tb_cadastro SET nome = ?, senha = ?, email = ?, cpf = ?, sexo = ?, idade = ?, admin = ? WHERE codigo = ?";
        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            // 4: Preenche os dados faltantes
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getCpf());
            ps.setString(5, usuario.getSexo());
            ps.setInt(6, usuario.getIdade());
            ps.setString(7, usuario.getAdmin());
            // 5: Executa o comando
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
