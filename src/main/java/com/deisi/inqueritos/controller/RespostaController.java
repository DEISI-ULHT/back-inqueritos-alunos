package com.deisi.inqueritos.controller;

import com.deisi.inqueritos.dto.RespostaDTO;
import com.deisi.inqueritos.services.RespostaService;
import com.deisi.inqueritos.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @Autowired
    private SessaoService sessaoService;

    @PostMapping("submit")
    public ResponseEntity<?> submitAnswer(@RequestBody RespostaDTO dto, HttpServletRequest request) {
        dto.setSession(sessaoService.assembleSessionCode(request));
        try {
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

    @GetMapping("session")
    public ResponseEntity<?> getBySession(HttpServletRequest request) {
        return ResponseEntity.ok(service.getBySession(sessaoService.assembleSessionCode(request)));
    }

    @GetMapping("session/{sessionCode}")
    public ResponseEntity<?> getBySessionId(HttpServletRequest request, @PathVariable String sessionCode) {
        return ResponseEntity.ok(service.getBySession(sessionCode));
    }
}
