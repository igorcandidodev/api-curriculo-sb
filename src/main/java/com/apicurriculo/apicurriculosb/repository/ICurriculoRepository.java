package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICurriculoRepository extends JpaRepository<Curriculo, Long>{

    @Query("SELECT c FROM Curriculo  c WHERE c.informacaoPessoal.nomeCompleto LIKE %:nome%")
    List<Curriculo> findAllByNome(String nome);
}
