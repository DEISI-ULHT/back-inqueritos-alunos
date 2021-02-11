package com.deisi.inqueritos.repository;
import com.deisi.inqueritos.model.PerguntaGeral;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaGeralRepository extends JpaRepository<PerguntaGeral, Long> {
}
