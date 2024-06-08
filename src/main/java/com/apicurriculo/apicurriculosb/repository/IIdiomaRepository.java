package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIdiomaRepository extends JpaRepository<Idioma, Long> {

    @Query("SELECT i FROM Idioma i WHERE i.nome LIKE %:nome%")
    List<Idioma> findAllByNome(String nome);
}
