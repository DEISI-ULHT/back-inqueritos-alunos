package com.deisi.inqueritos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "disciplina")
public class Disciplina {


    @Column(name = "id", unique = true)
    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano", length = 4)
    private int ano;

    @Column(name = "semestre", length = 1)
    private String semestre;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
