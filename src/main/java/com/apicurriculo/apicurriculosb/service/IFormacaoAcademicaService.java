package com.apicurriculo.apicurriculosb.service;

import com.apicurriculo.apicurriculosb.entity.FormacaoAcademica;

import java.util.List;

public interface IFormacaoAcademicaService {

        FormacaoAcademica updateFormacaoAcademica(Long id, FormacaoAcademica formacaoAcademica);
        void deleteFormacaoAcademica(Long id);
        FormacaoAcademica getFormacaoAcademicaById(Long id);
        List<FormacaoAcademica> getAllFormacaoAcademica();
        List<FormacaoAcademica> findAllByNomeCurso(String nomeCurso);
}
