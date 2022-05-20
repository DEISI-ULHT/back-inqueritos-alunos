package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,String> {

    public Disciplina getDisciplinaByCodigo(String codigo);
}
