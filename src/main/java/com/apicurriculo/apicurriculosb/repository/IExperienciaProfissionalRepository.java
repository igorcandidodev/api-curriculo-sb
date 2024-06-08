package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.ExperienciaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {
}
