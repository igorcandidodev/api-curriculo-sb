package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFerramentaRepository extends JpaRepository<Ferramenta, Long> {
}
