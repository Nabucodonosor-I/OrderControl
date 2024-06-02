package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexao.ConnectionFactory;
import Conexao.Evento;
import Conexao.Usuario;

public class Read {
    public ArrayList<Usuario> lerUsuarios() {
        // 1: Definir o comando SQL
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        String sql = "SELECT * FROM tb_cadastro";

        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            
            // 4: Executa o comando e guarda
            // no resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            // 5: itera sobre o resultado
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCpf(rs.getInt("cpf"));
                
                listaUsuario.add(usuario);
            }
            return listaUsuario;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public ArrayList<Evento> listarEventos() {
        // 1: Definir o comando SQL
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();
        String sql = "SELECT * FROM tb_eventos";

        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            // 3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            
            // 4: Executa o comando e guarda
            // no resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            // 5: itera sobre o resultado
            while (rs.next()) {
                Evento evento = new Evento();

                
                listaEventos.add(evento);
            }
            return listaEventos;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
