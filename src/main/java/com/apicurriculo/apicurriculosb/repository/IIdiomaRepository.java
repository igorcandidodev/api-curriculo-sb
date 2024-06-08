package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIdiomaRepository extends JpaRepository<Idioma, Long> {
}
