package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.ExperienciaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {

    @Query("SELECT e FROM ExperienciaProfissional e WHERE e.descricao LIKE %:description%")
    List<ExperienciaProfissional> findAllByDescription(String description);
}
