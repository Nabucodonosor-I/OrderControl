package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConnectionFactory;
import Conexao.Evento;
import Conexao.Usuario;

public class Delete {
    Usuario usuario = new Usuario();
    Evento evento = new Evento();
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

    public void deletarEvento() {
        // 1: Definir o comando SQL
        String sql = "DELETE FROM tb_eventos WHERE id = ?";
        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            // 4: Preenche os dados faltantes
            ps.setInt(1, evento.getId());
            // 5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}