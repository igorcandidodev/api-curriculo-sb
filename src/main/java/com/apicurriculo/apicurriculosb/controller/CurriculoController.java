package com.apicurriculo.apicurriculosb.controller;

import com.apicurriculo.apicurriculosb.dto.*;
import com.apicurriculo.apicurriculosb.entity.*;
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

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Curriculo>> findAllByNome(@PathVariable String nome) {
        return ResponseEntity.ok(curriculoService.findAllByNome(nome));
    }

    @PatchMapping("/formacao-academica/{idCurriculo}")
    @Transactional
    public ResponseEntity<Curriculo> addFormacaoAcademica(@PathVariable Long idCurriculo, @RequestBody FormacaoAcademicaDto formacaoAcademicaDto) {
        var formacaoAcademica = new FormacaoAcademica(formacaoAcademicaDto);
        return ResponseEntity.ok(curriculoService.addFormacaoAcademica(idCurriculo, formacaoAcademica));
    }

    @PatchMapping("/idioma/{idCurriculo}")
    @Transactional
    public ResponseEntity<Curriculo> addIdioma(@PathVariable Long idCurriculo, @RequestBody IdiomaDto idiomaDto) {
        var idioma = new Idioma(idiomaDto);
        return ResponseEntity.ok(curriculoService.addIdioma(idCurriculo, idioma));
    }

    @PatchMapping("/experiencia-profissional/{idCurriculo}")
    @Transactional
    public ResponseEntity<Curriculo> addExperienciaProfissional(@PathVariable Long idCurriculo, @RequestBody ExperienciaProfissionalDto experienciaProfissionalDto) {
        var experienciaProfissional = new ExperienciaProfissional(experienciaProfissionalDto);

        return ResponseEntity.ok(curriculoService.addExperienciaProfissional(idCurriculo, experienciaProfissional));
    }

    @PatchMapping("/ferramenta/{idCurriculo}")
    @Transactional
    public ResponseEntity<Curriculo> addFerramenta(@PathVariable Long idCurriculo, @RequestBody FerramentaDto ferramentaDto) {
        var ferramenta = new Ferramenta(ferramentaDto);
        return ResponseEntity.ok(curriculoService.addFerramenta(idCurriculo, ferramenta));
    }
}