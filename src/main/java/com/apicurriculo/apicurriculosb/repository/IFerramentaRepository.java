package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFerramentaRepository extends JpaRepository<Ferramenta, Long> {

    @Query("SELECT f FROM Ferramenta f WHERE f.nome LIKE %:nome%")
    List<Ferramenta> findAllByNome(String nome);
}
