package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConnectionFactory;
import Conexao.Usuario;

public class Delete {
    Usuario usuario = new Usuario();
    public void deletarUsuario() {
        // 1: Definir o comando SQL
        String sql = "DELETE FROM tb_cadastro WHERE id = ?";
        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            // 4: Preenche os dados faltantes
            ps.setInt(1, usuario.getId());
            // 5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}