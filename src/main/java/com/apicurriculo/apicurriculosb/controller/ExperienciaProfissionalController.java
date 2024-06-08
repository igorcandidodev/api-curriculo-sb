package com.apicurriculo.apicurriculosb.controller;

import com.apicurriculo.apicurriculosb.dto.ExperienciaProfissionalDto;
import com.apicurriculo.apicurriculosb.entity.ExperienciaProfissional;
import com.apicurriculo.apicurriculosb.service.IExperienciaProfissionalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia-profissional")
public class ExperienciaProfissionalController {

    private final IExperienciaProfissionalService experienciaProfissionalService;

    @Autowired
    public ExperienciaProfissionalController(IExperienciaProfissionalService experienciaProfissionalService) {
        this.experienciaProfissionalService = experienciaProfissionalService;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ExperienciaProfissional> updateExperienciaProfissional(@PathVariable Long id, @RequestBody ExperienciaProfissionalDto experienciaProfissionalDto) {
        var experienciaProfissional = new ExperienciaProfissional(experienciaProfissionalDto);
        return ResponseEntity.ok(experienciaProfissionalService.updateExperienciaProfissional(id, experienciaProfissional));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteExperienciaProfissional(@PathVariable Long id) {
        experienciaProfissionalService.deleteExperienciaProfissional(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaProfissional> getExperienciaProfissionalById(@PathVariable Long id) {
        return ResponseEntity.ok(experienciaProfissionalService.getExperienciaProfissionalById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExperienciaProfissional>> getAllExperienciaProfissionals() {
        return ResponseEntity.ok(experienciaProfissionalService.getAllExperienciaProfissional());
    }
}
