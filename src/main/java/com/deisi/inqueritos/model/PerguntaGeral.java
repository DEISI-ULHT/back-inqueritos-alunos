package com.deisi.inqueritos.model;


/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import javax.persistence.*;


@Entity
@Table(name = "pergunta_geral")
public class PerguntaGeral {
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column(name="id", unique = true)
    @Id
    private Long id;
    @Column(name = "tipo", length = 4)
    private String tipo;
    @Column(name = "opcoes")
    private String opcoes;
    @Column(name = "enunciado")
    private String enunciado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
