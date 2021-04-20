package com.deisi.inqueritos.model;

import javax.persistence.*;

@Entity
@Table(name = "professor_disciplina")
public class ProfessorDisciplina {
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
    @Column(name = "regente")
    private Boolean regente;
    @Column(name = "teorico")
    private Boolean teorico;
    @Column(name = "pratico")
    private Boolean pratico;

    @Id
    private String id;


    public Boolean getRegente() {
        return regente;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setRegente(Boolean regente) {
        this.regente = regente;
    }

    public Boolean getTeorico() {
        return teorico;
    }

    public void setTeorico(Boolean teorico) {
        this.teorico = teorico;
    }

    public Boolean getPratico() {
        return pratico;
    }

    public void setPratico(Boolean pratico) {
        this.pratico = pratico;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
