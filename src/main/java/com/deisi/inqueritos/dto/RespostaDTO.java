package com.deisi.inqueritos.dto;

public class RespostaDTO {
    private String disciplinaId;

    private String perguntaId;

    private String professorId;

    private String conteudo;
    private String session;


    public String getProfessorId() {
        return professorId;
    }


    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(String disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(String perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
