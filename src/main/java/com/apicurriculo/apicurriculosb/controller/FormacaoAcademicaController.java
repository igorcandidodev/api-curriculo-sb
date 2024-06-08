package com.apicurriculo.apicurriculosb.controller;

import com.apicurriculo.apicurriculosb.dto.FormacaoAcademicaDto;
import com.apicurriculo.apicurriculosb.entity.FormacaoAcademica;
import com.apicurriculo.apicurriculosb.service.IFormacaoAcademicaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formacao-academica")
public class FormacaoAcademicaController {

    private final IFormacaoAcademicaService formacaoAcademicaService;

    @Autowired
    public FormacaoAcademicaController(IFormacaoAcademicaService formacaoAcademicaService) {
        this.formacaoAcademicaService = formacaoAcademicaService;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FormacaoAcademica> updateFormacaoAcademica(@PathVariable Long id, @RequestBody FormacaoAcademicaDto formacaoAcademicaDto) {
        var formacaoAcademica = new FormacaoAcademica(formacaoAcademicaDto);

        return ResponseEntity.ok(formacaoAcademicaService.updateFormacaoAcademica(id, formacaoAcademica));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteFormacaoAcademica(@PathVariable Long id) {
        formacaoAcademicaService.deleteFormacaoAcademica(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormacaoAcademica> getFormacaoAcademicaById(@PathVariable Long id) {
        return ResponseEntity.ok(formacaoAcademicaService.getFormacaoAcademicaById(id));
    }

    @GetMapping
    public ResponseEntity<List<FormacaoAcademica>> getAllFormacaoAcademica() {
        return ResponseEntity.ok(formacaoAcademicaService.getAllFormacaoAcademica());
    }

}
