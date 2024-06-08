package com.apicurriculo.apicurriculosb.service;

import com.apicurriculo.apicurriculosb.entity.*;

import java.util.List;

public interface ICurriculoService {
    Curriculo createCurriculo(Curriculo curriculo);
    Curriculo updateCurriculo(Curriculo curriculo);
    void deleteCurriculo(Long id);
    Curriculo getCurriculoById(Long id);
    List<Curriculo> getAllCurriculos();
    List<Curriculo> findAllByNome(String nome);
    Curriculo addFormacaoAcademica(Long idCurriculo, FormacaoAcademica formacaoAcademica);
    Curriculo addExperienciaProfissional(Long idCurriculo, ExperienciaProfissional experienciaProfissional);
    Curriculo addIdioma(Long idCurriculo, Idioma Idioma);
    Curriculo addFerramenta(Long idCurriculo, Ferramenta ferramenta);
}