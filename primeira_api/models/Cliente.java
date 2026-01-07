package primeira_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Clientes")

public class Cliente {
    @Id
    private String ID_Cliente;
    private String nome;
    private String Email;

    public Cliente() {
    }

    public Cliente (String ID_Cliente, String nome, String Email) {
        this.ID_Cliente = ID_Cliente;
        this.nome = nome;
        this.Email = Email;
    }

    public String getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}