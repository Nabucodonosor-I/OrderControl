package Conexao;



public class Usuario{
    private static int id;
    private static String nome;
    private static String senha;
    private static String email;
    private static String sexo;
    private static int cpf;
    private static int idade;
    private static String admin;


    public int getId() {
        return id;
    }
    public static String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        Usuario.nome = nome;
    }
    public static String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        Usuario.senha = senha;
    }
    public static String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        Usuario.email = email;
    }
    public static String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        Usuario.sexo = sexo;
    }
    public static int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        Usuario.cpf = cpf;
    }
    public static int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        Usuario.idade = idade;
    } 

    public static String getAdmin() {
        return senha;
    }
    public void setAdmin(String admin) {
        Usuario.admin = admin;
    }
}