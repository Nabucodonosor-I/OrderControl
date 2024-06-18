package com.ordercontrol.DAO.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ordercontrol.DAO.ConnectionFactory;
import com.ordercontrol.model.*;

public class Read {
    public Usuario getUsuarioById(int idUsuario) {
        Usuario usuario = null;

        // 1: Definir o comando SQL
        String sql = "SELECT * FROM tb_cadastro WHERE id = ?";

        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idUsuario);

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

    public ArrayList<Evento> listarEventos() {
        Connection conn = null;
        // 1: Definir o comando SQL
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();
        String sql = "SELECT * FROM tb_eventos";

        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try {
            conn = factory.obtemConexao();
            // 3: Pré compila o comando
            PreparedStatement ps = conn.prepareStatement(sql);

            // 4: Executa o comando e guarda
            // no resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            // 5: itera sobre o resultado
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setTipoEvento(rs.getInt("tipoEvento"));
                evento.setNomeCliente(rs.getString("nomeCliente"));
                evento.setLocal(rs.getString("local"));
                evento.setData(rs.getString("data"));
                evento.setHora(rs.getString("hora"));
                evento.setDescricao(rs.getString("descricao"));
                evento.setUsuarios(rs.getInt("id_usuario1"), rs.getInt("id_usuario2"));
                listaEventos.add(evento);
            }
            return listaEventos;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

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
