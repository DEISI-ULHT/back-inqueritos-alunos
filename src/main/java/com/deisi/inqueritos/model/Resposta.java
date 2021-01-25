package com.deisi.inqueritos.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity(name = "resposta")
public class Resposta {

    @Column(name = "id", unique = true)
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private BigInteger id;

    public void setId(BigInteger id) {
        this.id = id;
    }
    @Id
    private BigInteger getId() {
        return id;
    }

    @Column(name = "entrada")
    private String entrada;

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getEntrada() {
        return entrada;
    }

    @Column(name = "ano")
    private Date ano;
    public void setAno (Date ano) {
        this.ano = ano;
    }

    public Date getAno() {
        return ano;
    }

    @Column(name = "semestre", length = 1)
    private String semestre;

    public void setSemestre (String semestre) {
        this.semestre = semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "id=" + id +
                ", entrada='" + entrada + '\'' +
                ", ano=" + ano +
                ", semestre='" + semestre + '\'' +
                '}';
    }
}
