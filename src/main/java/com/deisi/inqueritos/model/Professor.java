package com.deisi.inqueritos.model;


import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "professor")
public class Professor {
    @Column(name = "id", unique = true)
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "id_lusofona", unique = true)
    private String id_lusofona;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = false)
    private String email;


    public Professor() {
    }

    public Professor(String id_lusofona, String nome, String email, String tipo) {
        this.id_lusofona = id_lusofona;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_lusofona() {
        return id_lusofona;
    }

    public void setId_lusofona(String id_lusofona) {
        this.id_lusofona = id_lusofona;
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
                ", id_lusofona=" + id_lusofona +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
