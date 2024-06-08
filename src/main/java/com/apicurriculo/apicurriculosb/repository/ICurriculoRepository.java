package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurriculoRepository extends JpaRepository<Curriculo, Long>{
}
