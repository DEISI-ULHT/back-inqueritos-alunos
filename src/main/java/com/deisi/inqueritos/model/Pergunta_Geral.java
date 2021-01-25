package com.deisi.inqueritos.model;


/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/
import javax.persistence.*;


@Entity
@Table(name = "pergunta_Geral")
public class Pergunta_Geral {
    
    @Column(name="id", unique = true)
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }


}
