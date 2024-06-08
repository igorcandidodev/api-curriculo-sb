package com.apicurriculo.apicurriculosb.controller;

import com.apicurriculo.apicurriculosb.dto.CurriculoDto;
import com.apicurriculo.apicurriculosb.entity.Curriculo;
import com.apicurriculo.apicurriculosb.service.ICurriculoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculo")
public class CurriculoController {

    private final ICurriculoService curriculoService;

    @Autowired
    public CurriculoController(ICurriculoService curriculoService) {
        this.curriculoService = curriculoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Curriculo> createCurriculo(@RequestBody CurriculoDto curriculoDto) {
        var curriculo = new Curriculo(curriculoDto);

        return ResponseEntity.ok(curriculoService.createCurriculo(curriculo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Curriculo> updateCurriculo(@RequestBody Curriculo curriculo) {
        return ResponseEntity.ok(curriculoService.updateCurriculo(curriculo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Long id) {
        curriculoService.deleteCurriculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> getCurriculoById(@PathVariable Long id) {
        return ResponseEntity.ok(curriculoService.getCurriculoById(id));
    }

    @GetMapping
    public ResponseEntity<List<Curriculo>> getAllCurriculos() {
        return ResponseEntity.ok(curriculoService.getAllCurriculos());
    }
}