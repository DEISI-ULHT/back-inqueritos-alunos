package com.deisi.inqueritos.dto;

public class PerguntaEspecificaDTO {
    private String disciplinaId;
    private String tipo;
    private String opcoes;
    private String enunciado;
    private String a1;
    private String a2;
    private String a3;
    private String a4;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(String disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public PerguntaEspecificaDTO(String disciplinaId, String tipo, String opcoes, String enunciado, String a1, String a2, String a3, String a4) {
        this.disciplinaId = disciplinaId;
        this.tipo = tipo;
        this.opcoes = opcoes;
        this.enunciado = enunciado;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }

    public PerguntaEspecificaDTO() {
    }
}
