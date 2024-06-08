package com.apicurriculo.apicurriculosb.service;

import com.apicurriculo.apicurriculosb.entity.Ferramenta;

import java.util.List;

public interface IFerramentaService {

    Ferramenta updateFerramenta(Long id, Ferramenta ferramenta);
    void deleteFerramenta(Long id);
    Ferramenta getFerramentaById(Long id);
    List<Ferramenta> getAllFerramentas();
}
