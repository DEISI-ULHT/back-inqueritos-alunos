package com.deisi.inqueritos.model;

import com.deisi.inqueritos.dto.DisciplinaDTO;

import java.util.List;

public class ExportacaoDisciplina {
    private List<DisciplinaDTO> disciplinas;
    private List<PerguntaGeral> perguntasGerais;

    public List<DisciplinaDTO> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaDTO> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<PerguntaGeral> getPerguntasGerais() {
        return perguntasGerais;
    }

    public void setPerguntasGerais(List<PerguntaGeral> perguntasGerais) {
        this.perguntasGerais = perguntasGerais;
    }

    public ExportacaoDisciplina(List<DisciplinaDTO> disciplinas, List<PerguntaGeral> perguntasGerais) {
        this.disciplinas = disciplinas;
        this.perguntasGerais = perguntasGerais;
    }
}
