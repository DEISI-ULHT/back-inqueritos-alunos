package com.deisi.inqueritos.repository;
import com.deisi.inqueritos.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta,Long> {
}
