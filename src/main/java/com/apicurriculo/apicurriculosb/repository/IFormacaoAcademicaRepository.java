package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, Long> {

    @Query("SELECT f FROM FormacaoAcademica f WHERE f.curso LIKE %:nomeCurso%")
    List<FormacaoAcademica> findAllByNomeCurso(String nomeCurso);
}
