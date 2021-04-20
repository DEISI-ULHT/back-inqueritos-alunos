package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Curso_Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoDisciplinaRepository extends JpaRepository<Curso_Disciplina, Long> {
    List<Curso_Disciplina> getByDisciplinaId(String disciplina_id);
}
