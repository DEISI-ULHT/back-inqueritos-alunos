package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Professor_Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorDisciplinaRepository extends JpaRepository<Professor_Disciplina, Long> {
    List<Professor_Disciplina> getByDisciplinaId(Long disciplina_id);
}
