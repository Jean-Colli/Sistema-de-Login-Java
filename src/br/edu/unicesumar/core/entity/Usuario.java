package br.edu.unicesumar.core.entity;

public class Usuario {
    private String nome;
    private String login;
    private String email;
    private String senha;
    
    public Usuario(){
        setEmail(null);
        setLogin(null);
        setNome(null);
        setSenha(null);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
