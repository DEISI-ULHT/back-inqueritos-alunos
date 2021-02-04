package com.deisi.inqueritos.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table (name = "resposta")
public class Resposta {

    @Column(name = "id", unique = true)
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name="pergunta_geral_id",referencedColumnName = "id")
    private PerguntaGeral perguntaGeral;
    @OneToOne
    @JoinColumn(name="pergunta_especifica_id",referencedColumnName = "id")
    private PerguntaEspecifica perguntaEspecifica;
    @ManyToOne
    @JoinColumn(name="disciplina_id",nullable = false)
    private Disciplina disciplina;




    public void setId(Long id) {
        this.id = id;
    }

    private Long getId() {
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

    public PerguntaGeral getPerguntaGeral() {
        return perguntaGeral;
    }

    public void setPerguntaGeral(PerguntaGeral perguntaGeral) {
        this.perguntaGeral = perguntaGeral;
    }

    public PerguntaEspecifica getPerguntaEspecifica() {
        return perguntaEspecifica;
    }

    public void setPerguntaEspecifica(PerguntaEspecifica perguntaEspecifica) {
        this.perguntaEspecifica = perguntaEspecifica;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
