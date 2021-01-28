package com.deisi.inqueritos.model;


import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "professor")
public class Professor {
    @Column(name = "id", unique = true)
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_lusofona", unique = true)
    private Long id_lusofona;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = true)
    private String email;

    public Professor() {
    }

    public Professor(Long id_lusofona, String nome, String email) {
        this.id_lusofona = id_lusofona;
        this.nome = nome;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Long getId_lusofona() {
        return id_lusofona;
    }

    public void setId_lusofona(Long id_lusofona) {
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
}
