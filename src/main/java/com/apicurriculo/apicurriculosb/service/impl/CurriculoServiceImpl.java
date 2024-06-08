package com.apicurriculo.apicurriculosb.service.impl;

import com.apicurriculo.apicurriculosb.entity.Curriculo;
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

}
