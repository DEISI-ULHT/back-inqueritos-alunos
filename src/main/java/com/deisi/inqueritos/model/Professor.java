package com.deisi.inqueritos.model;


import javax.persistence.*;


@Entity
@Table(name = "professor")
public class Professor {
    @Column(name = "id", unique = true)
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "id_lusofona", unique = true)
    private String idLusofona;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = false)
    private String email;


    public Professor() {
    }

    public Professor(String idLusofona, String nome, String email) {
        this.idLusofona = idLusofona;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdLusofona() {
        return idLusofona;
    }

    public void setIdLusofona(String idLusofona) {
        this.idLusofona = idLusofona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", id_lusofona=" + idLusofona +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
