package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.PerguntaEspecifica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaEspecificaRepository extends JpaRepository<PerguntaEspecifica, Long> {

    List<PerguntaEspecifica> getByDisciplinaId(Long disciplina_id);
}
