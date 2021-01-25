package com.deisi.inqueritos.model;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

import javax.persistence.*;


@Entity
@Table(name="pergunta_Especifica")
public class Pergunta_Especifica {


    @Column(name="id", unique = true)
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    @Column(name = "tipo", length = 1)
    private Character tipo;

    public void setId(char id) {
        this.tipo = tipo;
    }

    public Character getTipo() {
        return tipo;
    }

    @Column(name = "opcoes")
    private String opcoes;

    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }

    public String getOpcoes() {
        return opcoes;
    }






}
