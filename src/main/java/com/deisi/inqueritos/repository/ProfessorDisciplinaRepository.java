package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.ProfessorDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorDisciplinaRepository extends JpaRepository<ProfessorDisciplina, Long> {
    List<ProfessorDisciplina> getByDisciplinaId(String disciplina_id);
}
