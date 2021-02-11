package com.deisi.inqueritos.dto;

import com.deisi.inqueritos.model.Curso;
import com.deisi.inqueritos.model.PerguntaEspecifica;
import com.deisi.inqueritos.model.PerguntaGeral;
import com.deisi.inqueritos.model.Professor;

import java.util.List;

public class DisciplinaDTO {
    private Long id;
    private String nome;
    private List<Professor> professores;
    private List<Curso> cursos;
    private List<PerguntaEspecifica> perguntaEspecifica;
    private List<PerguntaGeral> perguntaGeral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
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

    public List<PerguntaGeral> getPerguntaGeral() {
        return perguntaGeral;
    }

    public void setPerguntaGeral(List<PerguntaGeral> perguntaGeral) {
        this.perguntaGeral = perguntaGeral;
    }
}
