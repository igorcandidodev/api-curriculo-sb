package com.apicurriculo.apicurriculosb.service.impl;

import com.apicurriculo.apicurriculosb.entity.Idioma;
import com.apicurriculo.apicurriculosb.exception.ObjectNotFound;
import com.apicurriculo.apicurriculosb.repository.IIdiomaRepository;
import com.apicurriculo.apicurriculosb.service.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaServiceImpl implements IIdiomaService {

    private IIdiomaRepository idiomaRepository;

    @Autowired
    public IdiomaServiceImpl(IIdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }

    @Override
    public Idioma updateIdioma(Long id, Idioma idiomaNew) {

        var idiomaOld = idiomaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Idioma não encontrado com id: " + id));

        var idioma = updateData(idiomaOld, idiomaNew);
        return idiomaRepository.save(idioma);
    }

    @Override
    public void deleteIdioma(Long id) {
        idiomaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Idioma não encontrado com id: " + id));

        idiomaRepository.deleteById(id);
    }

    @Override
    public Idioma getIdiomaById(Long id) {
        return idiomaRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Idioma não encontrado com id: " + id));
    }

    @Override
    public List<Idioma> getAllIdiomas() {
        var idiomas = idiomaRepository.findAll();
        if(idiomas.isEmpty()) {
            throw new ObjectNotFound("Nenhum idioma encontrado");
        }

        return idiomas;
    }

    @Override
    public List<Idioma> findAllByNome(String nome) {

        var idiomas = idiomaRepository.findAllByNome(nome);

        if(idiomas.isEmpty()) {
            throw new ObjectNotFound("Nenhum idioma encontrado com o nome: " + nome);
        }

        return idiomas;
    }

    private Idioma updateData(Idioma idiomaOld, Idioma idiomaNew) {
        idiomaOld.setNome(idiomaNew.getNome());
        idiomaOld.setNivel(idiomaNew.getNivel());
        return idiomaOld;
    }
}
