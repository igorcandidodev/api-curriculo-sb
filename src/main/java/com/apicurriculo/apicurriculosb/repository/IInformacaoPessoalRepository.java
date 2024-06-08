package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.InformacaoPessoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInformacaoPessoalRepository extends JpaRepository<InformacaoPessoal, Long> {

    @Query("SELECT i FROM InformacaoPessoal i WHERE i.cargo LIKE %:cargo%")
    List<InformacaoPessoal> findAllByCargo(String cargo);
}
