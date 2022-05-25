package com.deisi.inqueritos.controller;

import com.deisi.inqueritos.model.Disciplina;
import com.deisi.inqueritos.model.ProfessorDisciplina;
import com.deisi.inqueritos.repository.DisciplinaRepository;
import com.deisi.inqueritos.repository.ProfessorDisciplinaRepository;
import com.deisi.inqueritos.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProfessorDisciplinaRepository professorDisciplinaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping("/profs")
    public String profs(ModelMap modelMap) {

        List<ProfessorDisciplina> all = professorDisciplinaRepository.findAll();
        List<ProfessorDisciplina> result = all
                .stream()
                .sorted(Comparator.comparingInt(ProfessorDisciplina::getAno)
                        .thenComparing(pd -> pd.getDisciplina().getSemestre())
                        .thenComparing(pd -> pd.getDisciplina().getNome()))
                .collect(Collectors.toList());

        modelMap.put("result", result);
        return "profs";
    }

    @GetMapping("/disc")
    public String disc(ModelMap modelMap) {

        List<Disciplina> all = disciplinaRepository.getDisciplinasBySemestreOrderByNome("2");
        List<Disciplina> result = all.stream()
                        .filter((d) -> d.getAno() != 4)
                        .collect(Collectors.toList());

        modelMap.put("result", result);
        return "disc";
    }

    @PostMapping("/generateProfsDisc")
    public String copyProfsDisc(@RequestParam int yearOrigin, @RequestParam int yearTarget, @RequestParam String semester) {

        List<ProfessorDisciplina> all = professorDisciplinaRepository.findAll();
        int maxId = all.stream()
                .mapToInt((pd) -> Integer.parseInt(pd.getId()))
                .max()
                .getAsInt();

        maxId++;

        List<ProfessorDisciplina> origin = professorDisciplinaRepository.getByAnoAndDisciplinaSemestre(yearOrigin, semester);

        for (ProfessorDisciplina originPD : origin) {
            ProfessorDisciplina newPD = new ProfessorDisciplina();
            newPD.setDisciplina(originPD.getDisciplina());
            newPD.setProfessor(originPD.getProfessor());
            newPD.setRegente(originPD.getRegente());
            newPD.setTeorico(originPD.getTeorico());
            newPD.setPratico(originPD.getPratico());
            newPD.setAno(yearTarget);
            newPD.setId(String.valueOf(maxId++));
            professorDisciplinaRepository.save(newPD);
        }

        return "redirect:/admin/profs";
    }
}
