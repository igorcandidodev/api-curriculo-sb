package com.apicurriculo.apicurriculosb.service;

import com.apicurriculo.apicurriculosb.entity.Curriculo;
import java.util.List;

public interface ICurriculoService {
    Curriculo createCurriculo(Curriculo curriculo);
    Curriculo updateCurriculo(Curriculo curriculo);
    void deleteCurriculo(Long id);
    Curriculo getCurriculoById(Long id);
    List<Curriculo> getAllCurriculos();
}