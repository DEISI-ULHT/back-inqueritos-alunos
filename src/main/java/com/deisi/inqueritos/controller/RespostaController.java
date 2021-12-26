package com.deisi.inqueritos.controller;

import com.deisi.inqueritos.dto.RespostaDTO;
import com.deisi.inqueritos.services.RespostaService;
import com.deisi.inqueritos.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/resposta")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @Autowired
    private SessaoService sessaoService;

    @PostMapping("submit")
    public ResponseEntity<?> submitAnswer(@RequestBody RespostaDTO dto, HttpServletRequest request) {
        try {
            // System.out.println("fui chamado: " + dto.getSession());
            service.saveDTO(dto);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (RuntimeException exception) {
            return new ResponseEntity(exception, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("get")
    public ResponseEntity<?> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("session/{sessionId}")
    public ResponseEntity<?> getBySession(@PathVariable String sessionId) {
        return ResponseEntity.ok(service.getBySession(sessionId));
    }

}
