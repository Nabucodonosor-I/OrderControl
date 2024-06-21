package com.ordercontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ordercontrol.model.Evento;

public class EventoDAO {
    public boolean criarEvento(Evento evento) {
        boolean eventoCriado = false;
        String sql = "INSERT INTO  tb_eventos(tipoEvento, nomeCliente, local, data, hora, descricao) VALUES(?, ?, ?, ?, ?, ?)";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, evento.getTipoEvento());
            ps.setString(2, evento.getNomeCliente());
            ps.setString(3, evento.getLocal());
            ps.setString(4, evento.getData());
            ps.setString(5, evento.getHora());
            ps.setString(6, evento.getDescricao());

            boolean result = ps.execute();

            if (!result) {
                eventoCriado = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventoCriado;
    }

    public void deletarEvento(int id) {
        // 1: Definir o comando SQL
        String sql = "DELETE FROM tb_eventos WHERE id = ?";
        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            // 4: Preenche os dados faltantes
            ps.setInt(1, id);
            // 5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public boolean inscreverUsuario(int idUsuario, int idEvento) {
        boolean cadastrado = false;
        String sqlRead = "SELECT ID_USUARIO1, ID_USUARIO2 FROM TB_EVENTOS WHERE ID = ?";
        String sqlUpdate = "UPDATE TB_EVENTOS SET ID_USUARIO1 = ?, ID_USUARIO2 = ? WHERE ID = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement readPs = c.prepareStatement(sqlRead);
            PreparedStatement updatePs = c.prepareStatement(sqlUpdate);

            readPs.setInt(1, idEvento);
            ResultSet rs = readPs.executeQuery();

            int idUsuario1 = 0;
            int idUsuario2 = 0;

            if (rs.next()) {
                idUsuario1 = rs.getInt("id_usuario1");
                idUsuario2 = rs.getInt("id_usuario2");
            }

            if (idUsuario1 == 0) {
                idUsuario1 = idUsuario;
                cadastrado = true;
            } else if (idUsuario2 == 0) {
                idUsuario2 = idUsuario;
                cadastrado = true;
            } else {
                cadastrado = false;
            }

            updatePs.setInt(1, idUsuario1);
            updatePs.setInt(2, idUsuario2);
            updatePs.setInt(3, idEvento);
            updatePs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cadastrado;
    }
}
