package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findCursoBySigla(String sigla);
}
