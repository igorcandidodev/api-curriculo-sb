package com.apicurriculo.apicurriculosb.repository;

import com.apicurriculo.apicurriculosb.entity.InformacaoPessoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformacaoPessoalRepository extends JpaRepository<InformacaoPessoal, Long> {
}
