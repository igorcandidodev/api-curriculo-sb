package com.apicurriculo.apicurriculosb.service.impl;

import com.apicurriculo.apicurriculosb.entity.InformacaoPessoal;
import com.apicurriculo.apicurriculosb.exception.ObjectNotFound;
import com.apicurriculo.apicurriculosb.repository.IInformacaoPessoalRepository;
import com.apicurriculo.apicurriculosb.service.IInformacaoPessoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacaoPessoalImpl implements IInformacaoPessoalService {

    private final IInformacaoPessoalRepository informacaoPessoalRepository;

    @Autowired
    public InformacaoPessoalImpl(IInformacaoPessoalRepository informacaoPessoalRepository) {
        this.informacaoPessoalRepository = informacaoPessoalRepository;
    }

    @Override
    public InformacaoPessoal updateInformacaoPessoal(Long id, InformacaoPessoal informacaoPessoalNew) {
        var informacaoPessoalOld = informacaoPessoalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Informação Pessoal não encontrada com id: " + id));

        var informacaoPessoal = updateData(informacaoPessoalOld, informacaoPessoalNew);
        return informacaoPessoalRepository.save(informacaoPessoal);
    }

    @Override
    public void deleteInformacaoPessoal(Long id) {
        informacaoPessoalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Informação Pessoal não encontrada com id: " + id));

        informacaoPessoalRepository.deleteById(id);

    }

    @Override
    public InformacaoPessoal getInformacaoPessoalById(Long id) {
        return  informacaoPessoalRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Informação Pessoal não encontrada com id: " + id));
    }

    @Override
    public List<InformacaoPessoal> getAllInformacaoPessoal() {
        var informacaoPessoal = informacaoPessoalRepository.findAll();
        if(informacaoPessoal.isEmpty()) {
            throw new ObjectNotFound("Nenhuma informação pessoal encontrada");
        }

        return informacaoPessoal;
    }

    @Override
    public List<InformacaoPessoal> findAllByCargo(String cargo) {

        var informacaoPessoal = informacaoPessoalRepository.findAllByCargo(cargo);

        if(informacaoPessoal.isEmpty()) {
            throw new ObjectNotFound("Nenhuma informação pessoal encontrada com o cargo: " + cargo);
        }

        return informacaoPessoal;
    }

    private InformacaoPessoal updateData(InformacaoPessoal informacaoPessoalOld, InformacaoPessoal informacaoPessoalNew) {
        informacaoPessoalOld.setNomeCompleto(informacaoPessoalNew.getNomeCompleto());
        informacaoPessoalOld.setCidade(informacaoPessoalNew.getCidade());
        informacaoPessoalOld.setEstado(informacaoPessoalNew.getEstado());
        informacaoPessoalOld.setEmail(informacaoPessoalNew.getEmail());
        informacaoPessoalOld.setPais(informacaoPessoalNew.getPais());
        informacaoPessoalOld.setCargo(informacaoPessoalNew.getCargo());

        return informacaoPessoalOld;
    }
}
