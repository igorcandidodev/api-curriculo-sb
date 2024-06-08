package com.apicurriculo.apicurriculosb.service.impl;

import com.apicurriculo.apicurriculosb.entity.Ferramenta;
import com.apicurriculo.apicurriculosb.exception.ObjectNotFound;
import com.apicurriculo.apicurriculosb.repository.IFerramentaRepository;
import com.apicurriculo.apicurriculosb.service.IFerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerramentaService implements IFerramentaService {

    private final IFerramentaRepository ferramentaRepository;

    @Autowired
    public FerramentaService(IFerramentaRepository ferramentaRepository) {
        this.ferramentaRepository = ferramentaRepository;
    }

    @Override
    public Ferramenta updateFerramenta(Long id, Ferramenta ferramenta) {
        var ferramentaOld = ferramentaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Ferramenta não encontrada com id: " + id));

        var ferramentaUpdated = updateData(ferramentaOld, ferramenta);

        return ferramentaRepository.save(ferramentaUpdated);
    }

    @Override
    public void deleteFerramenta(Long id) {
        var ferramenta = ferramentaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Ferramenta não encontrada com id: " + id));
        ferramentaRepository.delete(ferramenta);

    }

    @Override
    public Ferramenta getFerramentaById(Long id) {
        return ferramentaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Ferramenta não encontrada com id: " + id));
    }

    @Override
    public List<Ferramenta> getAllFerramentas() {
        var ferramentas = ferramentaRepository.findAll();

        if(ferramentas.isEmpty()) {
            throw new ObjectNotFound("Nenhuma ferramenta encontrada");
        }

        return ferramentas;
    }

    private Ferramenta updateData(Ferramenta ferramentaOld, Ferramenta ferramentaNew) {
        ferramentaOld.setNome(ferramentaNew.getNome());

        return ferramentaOld;
    }
}
