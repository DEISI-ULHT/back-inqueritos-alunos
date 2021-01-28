package com.deisi.inqueritos.dto;

import java.util.List;

public class CsvSeedDTO {
    private List<ProfessorDTO> professorDTO;
    private List<String> disciplinas;
    private List<ProfessorDisciplinaDTO> professorDisciplinaDTO;

    public List<ProfessorDTO> getProfessorDTO() {
        return professorDTO;
    }

    public void setProfessorDTO(List<ProfessorDTO> professorDTO) {
        this.professorDTO = professorDTO;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<ProfessorDisciplinaDTO> getProfessorDisciplinaDTO() {
        return professorDisciplinaDTO;
    }

    public void setProfessorDisciplinaDTO(List<ProfessorDisciplinaDTO> professorDisciplinaDTO) {
        this.professorDisciplinaDTO = professorDisciplinaDTO;
    }
}
