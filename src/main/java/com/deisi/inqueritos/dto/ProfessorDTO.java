package com.deisi.inqueritos.dto;

import com.deisi.inqueritos.model.Professor;
import com.deisi.inqueritos.model.ProfessorDisciplina;

public class ProfessorDTO {
    private Professor professor;
    private ProfessorDisciplina professor_disciplina;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ProfessorDisciplina getProfessor_disciplina() {
        return professor_disciplina;
    }

    public void setProfessor_disciplina(ProfessorDisciplina professor_disciplina) {
        this.professor_disciplina = professor_disciplina;
    }

    public ProfessorDTO(Professor professor, ProfessorDisciplina professor_disciplina) {
        this.professor = professor;
        this.professor_disciplina = professor_disciplina;
    }
}
