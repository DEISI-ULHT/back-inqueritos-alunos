package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    boolean existsByIdLusofona(String idLusofona);
    Professor findByIdLusofona(String idLusofona);

}
