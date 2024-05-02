package Conexao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConnectionFactory;
import Conexao.Usuario;

public class Update {
    public void atualizarUsuario (){
        //1: Definir o comando SQL
        String sql = "UPDATE TB_CADASTRO SET nome = ?, senha = ?, email = ?, cpf = ?, sexo = ?, idade = ?, admin = ? WHERE codigo = ?"  ;
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()){
        //3: Pré compila o comando
        PreparedStatement ps = c.prepareStatement(sql);
        //4: Preenche os dados faltantes
        ps.setString(1, Usuario.getNome());
        ps.setString(2, Usuario.getSenha());
        ps.setString(3, Usuario.getEmail());
        ps.setInt(4, Usuario.getCpf());
        ps.setString(5, Usuario.getSexo());
        ps.setInt(6, Usuario.getIdade());
        ps.setString(7, Usuario.getAdmin());
        //5: Executa o comando
        ps.execute();
       
        }
        catch (Exception e){
        e.printStackTrace();
        }
        }
}
