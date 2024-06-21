package com.ordercontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ordercontrol.model.Usuario;

public class UsuarioDAO {
    Usuario usuario = new Usuario();

    public boolean criarUsuario(Usuario usuario) {
        boolean userCriado = false;
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
            ps.setInt(7, usuario.getAdmin());

            boolean result = ps.execute();

            if (!result) {
                userCriado = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userCriado;
    }

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

}
