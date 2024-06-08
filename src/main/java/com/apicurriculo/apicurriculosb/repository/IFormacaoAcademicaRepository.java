package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, Long> {
}
