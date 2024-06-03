package Conexao;

public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String email;
    private String sexo;
    private int cpf;
    private int idade;
    private int admin;

    public Usuario() {

    }

    public Usuario(String nome, String senha, String email, String sexo, int cpf, int idade) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.sexo = sexo;
        this.cpf = cpf;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAdmin() {
        System.out.println(admin);
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

}