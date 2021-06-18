package com.deisi.inqueritos.services;

import com.deisi.inqueritos.dto.PerguntaEspecificaDTO;
import com.deisi.inqueritos.model.PerguntaEspecifica;
import com.deisi.inqueritos.repository.PerguntaEspecificaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerguntaEspecificaService {

    private PerguntaEspecificaRepository repository;

    private DisciplinaService disciplinaService;

    @Autowired
    public PerguntaEspecificaService(PerguntaEspecificaRepository repository, DisciplinaService disciplinaService) {
        this.repository = repository;
        this.disciplinaService = disciplinaService;
    }

    private PerguntaEspecifica convertendoDTO(PerguntaEspecificaDTO dto) {
        PerguntaEspecifica perguntaEspecifica = new PerguntaEspecifica();
        perguntaEspecifica.setDisciplina(disciplinaService.findById(dto.getDisciplinaId()));
        perguntaEspecifica.setEnunciado(dto.getEnunciado());
        perguntaEspecifica.setTipo(dto.getTipo());
        perguntaEspecifica.setOpcoes(dto.getOpcoes());
        return perguntaEspecifica;
    }

    public PerguntaEspecifica saveDTO(PerguntaEspecificaDTO dto) {
        if (Strings.isBlank(dto.getOpcoes()) && Strings.isBlank(dto.getA1()) && Strings.isBlank(dto.getA2()) && Strings.isBlank(dto.getA3()) && Strings.isBlank(dto.getA4())) {
            dto.setTipo("A");
        } else {
            dto.setTipo("F");
        }

        if (dto.getTipo().equals("A")) {
            dto.setOpcoes(Strings.EMPTY);
        } else {
            if (Strings.isBlank(dto.getOpcoes())) {
                dto.setOpcoes(dto.getA1().concat(",").concat(dto.getA2()).concat(",").concat(dto.getA3()).concat(",").concat(dto.getA4()));
            }
        }
        return repository.save(convertendoDTO(dto));
    }
}
