package com.apicurriculo.apicurriculosb.service.impl;

import com.apicurriculo.apicurriculosb.entity.ExperienciaProfissional;
import com.apicurriculo.apicurriculosb.exception.ObjectNotFound;
import com.apicurriculo.apicurriculosb.repository.IExperienciaProfissionalRepository;
import com.apicurriculo.apicurriculosb.service.IExperienciaProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaProfissionalImpl implements IExperienciaProfissionalService {

    private final IExperienciaProfissionalRepository experienciaProfissionalRepository;

    @Autowired
    public ExperienciaProfissionalImpl(IExperienciaProfissionalRepository experienciaProfissionalRepository) {
        this.experienciaProfissionalRepository = experienciaProfissionalRepository;
    }


    @Override
    public ExperienciaProfissional updateExperienciaProfissional(Long id, ExperienciaProfissional experienciaProfissional) {

        var experienciaProfissionalOld = experienciaProfissionalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Experiência Profissional não encontrada com id: " + id));

        var experienciaProfissionalUpdated = updateData(experienciaProfissionalOld, experienciaProfissional);

        return experienciaProfissionalRepository.save(experienciaProfissionalUpdated);
    }

    @Override
    public void deleteExperienciaProfissional(Long id) {
        var experienciaProfissional = experienciaProfissionalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Experiência Profissional não encontrada com id: " + id));
        experienciaProfissionalRepository.delete(experienciaProfissional);
    }

    @Override
    public ExperienciaProfissional getExperienciaProfissionalById(Long id) {
        return experienciaProfissionalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Experiência Profissional não encontrada com id: " + id));
    }

    @Override
    public List<ExperienciaProfissional> getAllExperienciaProfissional() {
        var experienciaProfissionals = experienciaProfissionalRepository.findAll();

        if(experienciaProfissionals.isEmpty()) {
            throw new ObjectNotFound("Nenhuma experiência profissional encontrada");
        }

        return experienciaProfissionals;
    }

    @Override
    public List<ExperienciaProfissional> findAllByDescription(String description) {
        var experienciaProfissionals = experienciaProfissionalRepository.findAllByDescription(description);

        if(experienciaProfissionals.isEmpty()) {
            throw new ObjectNotFound("Nenhuma experiência profissional encontrada com a descrição: " + description);
        }

        return experienciaProfissionals;
    }

    private ExperienciaProfissional updateData(ExperienciaProfissional experienciaProfissionalOld, ExperienciaProfissional experienciaProfissionalNew) {

        experienciaProfissionalOld.setDescricao(experienciaProfissionalNew.getDescricao());

        return experienciaProfissionalOld;
    }
}
