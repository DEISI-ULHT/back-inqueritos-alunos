package com.deisi.inqueritos.services;

import com.deisi.inqueritos.dto.DisciplinaDTO;
import com.deisi.inqueritos.model.*;
import com.deisi.inqueritos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private PerguntaEspecificaRepository perguntaEspecificaRepository;
    @Autowired
    private PerguntaGeralRepository perguntaGeralRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoDisciplinaRepository cursoDisciplinaRepository;

    @Autowired
    private ProfessorDisciplinaRepository professorDisciplinaRepository;


    private DisciplinaDTO montagemObjDisciplina(Disciplina disciplina) {

        //Optional<Disciplina> byId = disciplinaRepository.findById(disciplinaId);
        //Disciplina disciplina = byId.get();


        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();

        disciplinaDTO.setId(disciplina.getId());
        disciplinaDTO.setNome(disciplina.getNome());
        //Procura todas os cursos relacionados a tal disciplina
        List<Curso_Disciplina> byDisciplinaId = cursoDisciplinaRepository.getByDisciplinaId(disciplina.getId());
        List<Curso> cursos = byDisciplinaId.stream().map(Curso_Disciplina::getCurso).collect(Collectors.toList());

        List<Professor> professores = professorDisciplinaRepository.getByDisciplinaId(disciplina.getId())
                .stream().map(Professor_Disciplina::getProfessor).collect(Collectors.toList());


        disciplinaDTO.setCursos(cursos);
        disciplinaDTO.setProfessores(professores);
        disciplinaDTO.setPerguntaEspecifica(perguntaEspecificaRepository.getByDisciplinaId(disciplina.getId()));
        return disciplinaDTO;
    }

    public ExportacaoDisciplina exportaObj() {
        return new ExportacaoDisciplina(
                disciplinaRepository.findAll().stream().map(this::montagemObjDisciplina).collect(Collectors.toList())
                , perguntaGeralRepository.findAll());


    }


}
