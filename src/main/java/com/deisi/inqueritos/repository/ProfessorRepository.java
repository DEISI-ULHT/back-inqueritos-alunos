package com.deisi.inqueritos.repository;

import com.deisi.inqueritos.model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, BigInteger>{

}
