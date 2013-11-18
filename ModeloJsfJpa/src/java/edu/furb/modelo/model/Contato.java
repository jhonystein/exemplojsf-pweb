package edu.furb.modelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CONTATOS")
public class Contato {

    @Id @GeneratedValue
    @Column(name="ID_CONTATO")
    private long id;
    @Column(name="NM_CONTATO")
    private String nome;
    @Column(name="NM_TELEFONE")
    private String telefone;
    @Column(name="DS_EMAIL")
    private String email;
    @ManyToOne
    @JoinColumn(name="CATEGORIA_ID")
    private Categoria categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
