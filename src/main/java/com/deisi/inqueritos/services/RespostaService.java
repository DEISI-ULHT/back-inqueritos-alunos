package com.deisi.inqueritos.services;

import com.deisi.inqueritos.dto.RespostaDTO;
import com.deisi.inqueritos.model.Resposta;
import com.deisi.inqueritos.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RespostaService {
    //@Autowired
    private RespostaRepository repository;

    @Autowired
    public RespostaService(RespostaRepository repository) {
        this.repository = repository;
    }

    private Resposta convertDTO(RespostaDTO dto) {
        Resposta resposta = new Resposta();
        resposta.setDisciplinaId(dto.getDisciplinaId());
        resposta.setPerguntaId(dto.getPerguntaId());
        resposta.setProfessorId(dto.getProfessorId());
        resposta.setConteudo(dto.getConteudo());
        resposta.setSession(dto.getSession());
        resposta.setAnsweredAt(new Date());
        return resposta;
    }

    public Resposta saveDTO(RespostaDTO dto) {
        return repository.save(convertDTO(dto));
    }

    public Resposta getById(Integer id) {
        return repository.findById(Long.valueOf(id)).orElseThrow();
    }

    public List<Resposta> getAll() {
        return repository.findAll();
    }

    public List<Resposta> getBySession(String sessionCode) {
        return repository.getBySession(sessionCode);
    }
}
