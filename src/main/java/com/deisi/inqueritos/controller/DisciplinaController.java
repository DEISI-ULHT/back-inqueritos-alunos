package com.deisi.inqueritos.controller;

import com.deisi.inqueritos.model.ExportacaoDisciplina;
import com.deisi.inqueritos.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping("exportacao")
    public ResponseEntity<ExportacaoDisciplina> exportacaoDTO(HttpServletRequest request,
                                                              @RequestParam(name = "disciplina") String codigoDisciplina) {

        // os codigoDisciplina vêm sempre prefixados de "_" para facilitar as rewrite rules
        codigoDisciplina = codigoDisciplina.replaceFirst("_", "");
        return ResponseEntity.ok(disciplinaService.exportaObj(request,codigoDisciplina));
    }
}
