package com.apicurriculo.apicurriculosb.service;

import com.apicurriculo.apicurriculosb.entity.ExperienciaProfissional;

import java.util.List;

public interface IExperienciaProfissionalService {

    ExperienciaProfissional updateExperienciaProfissional(Long id, ExperienciaProfissional experienciaProfissional);
    void deleteExperienciaProfissional(Long id);
    ExperienciaProfissional getExperienciaProfissionalById(Long id);
    List<ExperienciaProfissional> getAllExperienciaProfissional();
    List<ExperienciaProfissional> findAllByDescription(String description);
}
