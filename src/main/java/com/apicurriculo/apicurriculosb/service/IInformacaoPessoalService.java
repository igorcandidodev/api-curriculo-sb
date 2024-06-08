package com.apicurriculo.apicurriculosb.service;

import com.apicurriculo.apicurriculosb.entity.InformacaoPessoal;

import java.util.List;

public interface IInformacaoPessoalService {

    InformacaoPessoal updateInformacaoPessoal(Long id, InformacaoPessoal informacaoPessoalNew);
    void deleteInformacaoPessoal(Long id);
    InformacaoPessoal getInformacaoPessoalById(Long id);
    List<InformacaoPessoal> getAllInformacaoPessoal();
}
