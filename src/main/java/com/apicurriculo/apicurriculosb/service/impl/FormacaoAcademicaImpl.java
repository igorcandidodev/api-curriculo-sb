package com.apicurriculo.apicurriculosb.service.impl;

import com.apicurriculo.apicurriculosb.entity.FormacaoAcademica;
import com.apicurriculo.apicurriculosb.exception.ObjectNotFound;
import com.apicurriculo.apicurriculosb.repository.IFormacaoAcademicaRepository;
import com.apicurriculo.apicurriculosb.service.IFormacaoAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormacaoAcademicaImpl implements IFormacaoAcademicaService {

    private final IFormacaoAcademicaRepository formacaoAcademicaRepository;

    @Autowired
    public FormacaoAcademicaImpl(IFormacaoAcademicaRepository formacaoAcademicaRepository) {
        this.formacaoAcademicaRepository = formacaoAcademicaRepository;
    }

    @Override
    public FormacaoAcademica updateFormacaoAcademica(Long id, FormacaoAcademica formacaoAcademicaNew) {

        var formacaoAcademicaOld = formacaoAcademicaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Formação acadêmica não encontrada com id: " + id));
        var formacaoAcademica = updateData(formacaoAcademicaOld, formacaoAcademicaNew);

        return formacaoAcademicaRepository.save(formacaoAcademica);
    }

    @Override
    public void deleteFormacaoAcademica(Long id) {
        var formacaoAcademica = formacaoAcademicaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Formação acadêmica não encontrada com id: " + id));
        formacaoAcademicaRepository.delete(formacaoAcademica);
    }

    @Override
    public FormacaoAcademica getFormacaoAcademicaById(Long id) {
        return formacaoAcademicaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Formação acadêmica não encontrada com id: " + id));
    }

    @Override
    public List<FormacaoAcademica> getAllFormacaoAcademica() {
        return formacaoAcademicaRepository.findAll();
    }

    @Override
    public List<FormacaoAcademica> findAllByNomeCurso(String nomeCurso) {

        var formacaoAcademicas = formacaoAcademicaRepository.findAllByNomeCurso(nomeCurso);

        if(formacaoAcademicas.isEmpty()) {
            throw new ObjectNotFound("Nenhuma formação acadêmica encontrada com o nome do curso: " + nomeCurso);
        }

        return formacaoAcademicas;
    }

    private FormacaoAcademica updateData(FormacaoAcademica formacaoAcademicaOld, FormacaoAcademica formacaoAcademicaNew) {

        formacaoAcademicaOld.setCurso(formacaoAcademicaNew.getCurso());
        formacaoAcademicaOld.setInstituicao(formacaoAcademicaNew.getInstituicao());
        formacaoAcademicaOld.setDataFim(formacaoAcademicaNew.getDataFim());
        formacaoAcademicaOld.setDataInicio(formacaoAcademicaNew.getDataInicio());
        formacaoAcademicaOld.setDataFim(formacaoAcademicaNew.getDataFim());

        return formacaoAcademicaOld;
    }
}
