package com.deisi.inqueritos.model;

import javax.persistence.*;

@Entity
@Table(name = "professor_disciplina")
public class ProfessorDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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

    @Column(name = "ano", length = 4)
    private int ano;

    @Column(name = "semestre", length = 1)
    private int semestre;

    public ProfessorDisciplina() {
    }

    public ProfessorDisciplina(Disciplina disciplina, Professor professor, Boolean regente, Boolean teorico, Boolean pratico, int ano, int semestre) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.regente = regente;
        this.teorico = teorico;
        this.pratico = pratico;
        this.ano = ano;
        this.semestre = semestre;
    }

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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
