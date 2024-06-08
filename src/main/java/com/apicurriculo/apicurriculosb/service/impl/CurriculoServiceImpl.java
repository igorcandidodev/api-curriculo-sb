package com.apicurriculo.apicurriculosb.service.impl;

import com.apicurriculo.apicurriculosb.entity.*;
import com.apicurriculo.apicurriculosb.exception.ObjectNotFound;
import com.apicurriculo.apicurriculosb.repository.ICurriculoRepository;
import com.apicurriculo.apicurriculosb.service.ICurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculoServiceImpl implements ICurriculoService {

    private final ICurriculoRepository curriculoRepository;

    @Autowired
    public CurriculoServiceImpl(ICurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }

    @Override
    public Curriculo createCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    @Override
    public Curriculo updateCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    @Override
    public void deleteCurriculo(Long id) {
        curriculoRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Curriculo não encontrado com id: " + id));

        curriculoRepository.deleteById(id);
    }

    @Override
    public Curriculo getCurriculoById(Long id) {

        return curriculoRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Curriculo não encontrado com id: " + id));
    }

    @Override
    public List<Curriculo> getAllCurriculos() {

        var curriculos = curriculoRepository.findAll();
        if(curriculos.isEmpty()) {
            throw new ObjectNotFound("Nenhum curriculo encontrado");
        }

        return curriculos;
    }

    @Override
    public List<Curriculo> findAllByNome(String nome) {
        var curriculos = curriculoRepository.findAllByNome(nome);
        if(curriculos.isEmpty()) {
            throw new ObjectNotFound("Nenhum curriculo encontrado com o nome: " + nome);
        }

        return curriculos;
    }

    @Override
    public Curriculo addFormacaoAcademica(Long idCurriculo, FormacaoAcademica formacaoAcademica) {
        var curriculo = curriculoRepository.findById(idCurriculo).orElseThrow(() -> new ObjectNotFound("Curriculo não encontrado com id: " + idCurriculo));

        formacaoAcademica.setCurriculo(curriculo);
        curriculo.getFormacaoAcademica().add(formacaoAcademica);

        return curriculoRepository.save(curriculo);
    }

    @Override
    public Curriculo addExperienciaProfissional(Long idCurriculo, ExperienciaProfissional experienciaProfissional) {

        var curriculo = curriculoRepository.findById(idCurriculo).orElseThrow(() -> new ObjectNotFound("Curriculo não encontrado com id: " + idCurriculo));

        experienciaProfissional.setCurriculo(curriculo);
        curriculo.getExperienciaProfissional().add(experienciaProfissional);

        return curriculoRepository.save(curriculo);
    }

    @Override
    public Curriculo addIdioma(Long idCurriculo, Idioma idioma) {

        var curriculo = curriculoRepository.findById(idCurriculo).orElseThrow(() -> new ObjectNotFound("Curriculo não encontrado com id: " + idCurriculo));

        idioma.setCurriculo(curriculo);
        curriculo.getIdioma().add(idioma);

        return curriculoRepository.save(curriculo);
    }

    @Override
    public Curriculo addFerramenta(Long idCurriculo, Ferramenta ferramenta) {

        var curriculo = curriculoRepository.findById(idCurriculo).orElseThrow(() -> new ObjectNotFound("Curriculo não encontrado com id: " + idCurriculo));

        ferramenta.setCurriculo(curriculo);
        curriculo.getFerramenta().add(ferramenta);

        return curriculoRepository.save(curriculo);
    }

}
