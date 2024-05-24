package Conexao;

import java.util.ArrayList;

public class Usuario {
    ArrayList<Usuario> usuarioList = new ArrayList<>();
    private  int id;
    private  String nome;
    private  String senha;
    private  String email;
    private  String sexo;
    private  int cpf;
    private  int idade;
    private  String admin;
    
    public Usuario() {

    }

    public  int getId() {
        return id;
    }

    public  String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public  String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public  int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public  int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public  String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

}