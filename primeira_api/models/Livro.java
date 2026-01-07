package primeira_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Livros")

public class Livro {
    @Id
    String ID_Livro;
    String titulo;
    String autor;
    String anoPublicacao;
    String genero;

    public Livro() {
    }

    public Livro (String ID_Livro, String titulo, String autor, String anoPublicacao, String genero) {
        this.ID_Livro = ID_Livro;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }
    public String getID_Livro() {
        return ID_Livro;
    }
    public void setID_Livro(String ID_Livro) {
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