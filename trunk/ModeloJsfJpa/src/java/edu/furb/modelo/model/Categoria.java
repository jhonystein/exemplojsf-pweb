package edu.furb.modelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author senai-sc
 */
@Entity
@Table(name="TB_CATEGORIAS")
public class Categoria {
    
    @Id @GeneratedValue
    @Column(name="CATEGORIA_ID")
    private long id;
    @Column(name="NM_CATEGORIA")
    private String nome;

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

}
