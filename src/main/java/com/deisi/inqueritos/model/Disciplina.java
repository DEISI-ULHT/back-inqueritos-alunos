package com.deisi.inqueritos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "disciplina")
public class Disciplina {


    @Column(name = "id", unique = true)
    @Id
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano", length = 4)
    private int ano;

    @Column(name = "semestre", length = 1)
    private String semestre;

    @Column(name = "codigo", length = 6, unique = true)
    private String codigo;

    @Transient
    private int numRespostas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumRespostas() {
        return numRespostas;
    }

    public void setNumRespostas(int numRespostas) {
        this.numRespostas = numRespostas;
    }
}
