package com.biblioteca.biblioteca_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "clientes")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_Cliente;
    private String nome;

    public Cliente() {
    }

    public Cliente (String nome) {
        this.nome = nome;
    }

    public long getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(long ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}