package com.deisi.inqueritos.controller;

import com.deisi.inqueritos.model.Disciplina;
import com.deisi.inqueritos.model.Professor;
import com.deisi.inqueritos.repository.DisciplinaRepository;
import com.deisi.inqueritos.repository.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InqueritosStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    final static String[] letters = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "Y", "X", "W", "Z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    Logger LOG = LoggerFactory.getLogger(InqueritosStartupListener.class);

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOG.info("********** Starting Inqueritos Backend **********");

//        List<Disciplina> disciplinas = disciplinaRepository.findAll();
//        for (Disciplina disciplina : disciplinas) {
//            if (disciplina.getCodigo() == null) {
//                boolean repeatedCode = false;
//                do {
//                    String codigo = "";
//                    for (int i = 0; i < 6; i++) {
//                        codigo += letters[(int) (Math.random() * letters.length)];
//                    }
//
//                    if (disciplinaRepository.getDisciplinaByCodigo(codigo) != null) {
//                        repeatedCode = true;
//                    } else {
//                        disciplina.setCodigo(codigo);
//                        disciplinaRepository.save(disciplina);
//                    }
//                } while (repeatedCode);
//            }
//        }
    }
}
