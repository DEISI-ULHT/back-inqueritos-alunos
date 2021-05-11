package com.deisi.inqueritos.services;

import com.deisi.inqueritos.dto.PerguntaEspecificaDTO;
import com.deisi.inqueritos.model.PerguntaEspecifica;
import com.deisi.inqueritos.repository.PerguntaEspecificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerguntaEspecificaService {
    @Autowired
    private PerguntaEspecificaRepository repository;
    @Autowired
    private DisciplinaService disciplinaService;

    private PerguntaEspecifica convertendoDTO(PerguntaEspecificaDTO dto) {
        PerguntaEspecifica perguntaEspecifica = new PerguntaEspecifica();
        perguntaEspecifica.setDisciplina(disciplinaService.findById(dto.getDisciplinaId()));
        perguntaEspecifica.setEnunciado(dto.getEnunciado());
        perguntaEspecifica.setTipo(dto.getTipo());
        perguntaEspecifica.setOpcoes(dto.getOpcoes());
        return perguntaEspecifica;
    }

    public PerguntaEspecifica saveDTO(PerguntaEspecificaDTO dto) {
        return repository.save(convertendoDTO(dto));
    }


}
