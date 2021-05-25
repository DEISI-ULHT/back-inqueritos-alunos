package com.deisi.inqueritos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String disciplinaId;

    private String perguntaId;
    private String professorId;
    @Column(length=8000)
    private String conteudo;
    private String session;
    private Date answeredAt;


    public Date getAnsweredAt() {
        return answeredAt;
    }

    public void setAnsweredAt(Date answeredAt) {
        this.answeredAt = answeredAt;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(String disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(String perguntaId) {
        this.perguntaId = perguntaId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
