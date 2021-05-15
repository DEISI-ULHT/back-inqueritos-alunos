package com.deisi.inqueritos.model;

import com.deisi.inqueritos.dto.DisciplinaDTO;

import java.util.List;

public class ExportacaoDisciplina {
    private DisciplinaDTO disciplina;
    private List<PerguntaGeral> perguntasGerais;
    private String token;


    public List<PerguntaGeral> getPerguntasGerais() {
        return perguntasGerais;
    }

    public void setPerguntasGerais(List<PerguntaGeral> perguntasGerais) {
        this.perguntasGerais = perguntasGerais;
    }

    public DisciplinaDTO getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaDTO disciplina) {
        this.disciplina = disciplina;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ExportacaoDisciplina(DisciplinaDTO disciplina, List<PerguntaGeral> perguntasGerais, String token) {
        this.disciplina = disciplina;
        this.perguntasGerais = perguntasGerais;
        this.token = token;
    }
}
