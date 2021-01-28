package com.deisi.inqueritos.model;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

import javax.persistence.*;


@Entity
@Table(name= "pergunta_especifica")
public class PerguntaEspecifica {


    @Column(name="id", unique = true)
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Column(name = "tipo", length = 1)
    private Character tipo;

    public void setTipo(char id) {
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
