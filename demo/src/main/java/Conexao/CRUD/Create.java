package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConnectionFactory;
import Conexao.*;

public class Create {
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

           if(!result) {
            userCriado = true;
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userCriado;
    }

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

           if(!result) {
            eventoCriado = true;
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventoCriado;
    }
}