package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    List<Resposta> getBySession(String session);
    List<Resposta> getBySessionOrderByAnsweredAt(String session);

    List<Resposta> getByDisciplinaIdAndAnsweredAtAfter(String disciplinaId, Date answeredAt);

    @Transactional
    int deleteBySession(String session);
}
