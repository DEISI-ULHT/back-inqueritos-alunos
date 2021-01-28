package com.deisi.inqueritos.dto;

import java.util.List;

public class ProfessorDTO {
    private String id;
    private String professor;
    private String email;
    private List<String> disciplinas;
    private String tipo; //TODO: Tipagem

    public ProfessorDTO() {
    }

    public ProfessorDTO(String professor, String email, List<String> disciplinas) {
        this.professor = professor;
        this.email = email;
        this.disciplinas = disciplinas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
