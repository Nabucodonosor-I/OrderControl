package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ordercontrol.TelaCadastroLogin;

import Conexao.ConnectionFactory;

public class ValidarUsuario {
    public int lerUsuario() {

        TelaCadastroLogin login = new TelaCadastroLogin();

        String digtUsuario = login.getTextUsuario();
        String digtSenha = login.getTextSenha();
        int idValidUsuario = 0;
        
        // 1: Definir o comando SQL
        try {  
            String sql = "SELECT * FROM tb_cadastro WHERE (email = '"+ digtUsuario + "' and senha = '" + digtSenha + "')";
            System.out.println(sql);
            
            // 2: Abrir uma conexão
            ConnectionFactory factory = new ConnectionFactory();
            try (Connection c = factory.obtemConexao()) {
                // 3: Pré compila o comando
                PreparedStatement ps = c.prepareStatement(sql);

                // 4: Executa o comando e guarda
                // o resultado em um ResultSet
                ResultSet rs = ps.executeQuery();
                idValidUsuario = rs.getInt("id");       
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idValidUsuario;
        }catch (NumberFormatException e){
           return idValidUsuario = 0;
        }
    }
}