package com.deisi.inqueritos.dto;

import com.deisi.inqueritos.model.*;

import java.util.List;

public class DisciplinaDTO {
    private String id;
    private String nome;
    private List<ProfessorDisciplina> professores;
    private List<Curso> cursos;
    private List<PerguntaEspecifica> perguntaEspecifica;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ProfessorDisciplina> getProfessores() {
        return professores;
    }

    public void setProfessores(List<ProfessorDisciplina> professores) {
        this.professores = professores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<PerguntaEspecifica> getPerguntaEspecifica() {
        return perguntaEspecifica;
    }

    public void setPerguntaEspecifica(List<PerguntaEspecifica> perguntaEspecifica) {
        this.perguntaEspecifica = perguntaEspecifica;
    }




}
