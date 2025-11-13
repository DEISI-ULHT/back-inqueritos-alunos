package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,String> {

    public Disciplina getDisciplinaByCodigo(String codigo);

    public List<Disciplina> getDisciplinasBySemestreOrderByNome(String semestre);

    @Query("SELECT DISTINCT d FROM Disciplina d JOIN ProfessorDisciplina pd ON pd.disciplina = d WHERE pd.ano = :ano AND pd.semestre = :semestre ORDER BY d.nome")
    public List<Disciplina> findDisciplinasWithProfessorsByAnoAndSemestre(@Param("ano") int ano, @Param("semestre") int semestre);
}
