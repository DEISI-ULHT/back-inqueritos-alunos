package com.deisi.inqueritos.model;

import com.deisi.inqueritos.dto.DisciplinaDTO;

import java.util.List;

public class ExportacaoDisciplina {
    private DisciplinaDTO disciplina;
    private List<PerguntaGeral> perguntasGerais;



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

    public ExportacaoDisciplina(DisciplinaDTO disciplina, List<PerguntaGeral> perguntasGerais) {
        this.disciplina = disciplina;
        this.perguntasGerais = perguntasGerais;
    }
}
