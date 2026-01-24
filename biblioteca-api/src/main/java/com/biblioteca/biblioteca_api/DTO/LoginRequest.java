package com.biblioteca.biblioteca_api.DTO;


public class LoginRequest {
    private String email;
    private String senha;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
}
