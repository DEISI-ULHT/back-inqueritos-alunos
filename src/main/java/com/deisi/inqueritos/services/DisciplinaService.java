package com.deisi.inqueritos.services;

import com.deisi.inqueritos.dto.DisciplinaDTO;
import com.deisi.inqueritos.model.*;
import com.deisi.inqueritos.repository.*;
import com.deisi.inqueritos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {
///autowired - injeção de dependencia
///repository é para acesso de banco

    @Autowired
    private SessaoService sessaoService;
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


        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();

        disciplinaDTO.setId(disciplina.getId());//id da disciplina
        disciplinaDTO.setNome(disciplina.getNome()); //nome da disciplina
        //Procura todas os cursos relacionados a tal disciplina
        List<Curso_Disciplina> byDisciplinaId = cursoDisciplinaRepository.getByDisciplinaId(disciplina.getId()); //pego todos os objetos curso disciplina
        List<Curso> cursos = byDisciplinaId.stream().map(Curso_Disciplina::getCurso).collect(Collectors.toList()); //pegando só os filtros dessa disciplina

        List<ProfessorDisciplina> professores = professorDisciplinaRepository.getByDisciplinaId(disciplina.getId()); //


        disciplinaDTO.setCursos(cursos);
        disciplinaDTO.setProfessores(professores);
        disciplinaDTO.setPerguntaEspecifica(perguntaEspecificaRepository.getByDisciplinaId(disciplina.getId()));
        return disciplinaDTO;
    }

    public ExportacaoDisciplina exportaObj(HttpServletRequest request, String disciplina) {


        return new ExportacaoDisciplina(
                montagemObjDisciplina(disciplinaRepository.findById(disciplina).get())
             , perguntaGeralRepository.findAll(), TokenUtils.assembleToken());


    }

    public Disciplina findById(String id){
        return disciplinaRepository.findById(id).orElse(null);
    }




}
