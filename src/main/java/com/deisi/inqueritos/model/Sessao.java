package com.deisi.inqueritos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessao")
public class Sessao {
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Boolean aberta;

    @Column(name = "ip", unique = true)
    private String ip;

    public Sessao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getAberta() {
        return aberta;
    }

    public void setAberta(Boolean aberta) {
        this.aberta = aberta;
    }

    public Sessao(String ip) {
        this.ip = ip;
        this.aberta = Boolean.TRUE;
    }
}
