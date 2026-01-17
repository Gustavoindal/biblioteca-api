package com.biblioteca.biblioteca_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "livros")

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_Livro;
    private String titulo;
    private String autor;
    private String anoPublicacao;
    private String genero;
    public Livro() {
    }

    public Livro (long ID_Livro, String titulo, String autor, String anoPublicacao, String genero) {
        this.ID_Livro = ID_Livro;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }
    public long getID_Livro() {
        return ID_Livro;
    }
    public void setID_Livro(long ID_Livro) {
        this.ID_Livro = ID_Livro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    
}