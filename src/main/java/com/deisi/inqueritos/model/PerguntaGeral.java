package com.deisi.inqueritos.model;


/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import javax.persistence.*;


@Entity
@Table(name = "pergunta_Geral")
public class PerguntaGeral {
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column(name="id", unique = true)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }


}
