package com.apicurriculo.apicurriculosb.controller;

import com.apicurriculo.apicurriculosb.dto.FerramentaDto;
import com.apicurriculo.apicurriculosb.entity.Ferramenta;
import com.apicurriculo.apicurriculosb.service.impl.FerramentaService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ferramenta")
public class FerramentaController {

    private final FerramentaService ferramentaService;

    public FerramentaController(FerramentaService ferramentaService) {
        this.ferramentaService = ferramentaService;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Ferramenta> updateFerramenta(@PathVariable Long id, @RequestBody FerramentaDto ferramentaDto) {
        var ferramenta = new Ferramenta(ferramentaDto);
        return ResponseEntity.ok(ferramentaService.updateFerramenta(id, ferramenta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteFerramenta(@PathVariable Long id) {
        ferramentaService.deleteFerramenta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ferramenta> getFerramentaById(@PathVariable Long id) {
        return ResponseEntity.ok(ferramentaService.getFerramentaById(id));
    }

    @GetMapping
    public ResponseEntity<List<Ferramenta>> getAllFerramentas() {
        return ResponseEntity.ok(ferramentaService.getAllFerramentas());
    }
}
