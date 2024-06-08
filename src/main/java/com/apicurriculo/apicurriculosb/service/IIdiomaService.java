package com.apicurriculo.apicurriculosb.service;

import com.apicurriculo.apicurriculosb.entity.Idioma;

import java.util.List;

public interface IIdiomaService {

    Idioma updateIdioma(Long id, Idioma idiomaNew);
    void deleteIdioma(Long id);
    Idioma getIdiomaById(Long id);
    List<Idioma> getAllIdiomas();
}
