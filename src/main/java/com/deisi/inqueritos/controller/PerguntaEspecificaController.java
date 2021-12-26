package com.deisi.inqueritos.controller;
import com.deisi.inqueritos.dto.PerguntaEspecificaDTO;
import com.deisi.inqueritos.dto.RespostaDTO;
import com.deisi.inqueritos.services.PerguntaEspecificaService;
import com.deisi.inqueritos.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/perguntaEspecifica")
    public class PerguntaEspecificaController {
    @Autowired
    private PerguntaEspecificaService perguntaEspecificaService;

    @PostMapping("tenta")
    public ResponseEntity<?>  submitAnswer(@ModelAttribute  PerguntaEspecificaDTO dto) {
       //ModelAtribute
        try {
            perguntaEspecificaService.saveDTO(dto);
            return new ResponseEntity(HttpStatus.ACCEPTED);

        } catch (RuntimeException exception) {
            return new ResponseEntity(exception, HttpStatus.NOT_ACCEPTABLE);

        }

    }
}
