package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Disciplina;
import com.deisi.inqueritos.model.Professor;
import com.deisi.inqueritos.model.ProfessorDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorDisciplinaRepository extends JpaRepository<ProfessorDisciplina, Long> {
    List<ProfessorDisciplina> getByDisciplinaIdAndAno(String disciplinaId, int ano);
    List<ProfessorDisciplina> getByAnoAndDisciplinaSemestre(int ano, String semestre);
    boolean existsByDisciplinaAndProfessorAndAnoAndSemestre(Disciplina disciplina, Professor professor, int ano, int semestre);
}
