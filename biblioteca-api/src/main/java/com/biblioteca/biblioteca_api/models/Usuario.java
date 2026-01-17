package com.biblioteca.biblioteca_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_Usuario;
    private String email;
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    public Usuario() {
    }

    public Usuario(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(long ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}