package com.ordercontrol.DAO.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ordercontrol.DAO.ConnectionFactory;
import com.ordercontrol.model.*;



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
            ps.setInt(7, usuario.getAdmin());
            // 5: Executa o comando
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
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
