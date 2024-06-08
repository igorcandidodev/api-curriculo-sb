package com.apicurriculo.apicurriculosb.controller;

import com.apicurriculo.apicurriculosb.dto.IdiomaDto;
import com.apicurriculo.apicurriculosb.entity.Idioma;
import com.apicurriculo.apicurriculosb.service.IIdiomaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/idioma")
public class IdiomaController {

    private final IIdiomaService idiomaService;

    @Autowired
    public IdiomaController(IIdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Idioma> updateIdioma(@PathVariable Long id, @RequestBody IdiomaDto idiomaDto) {
        var idioma = new Idioma(idiomaDto);
        return ResponseEntity.ok(idiomaService.updateIdioma(id, idioma));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteIdioma(@PathVariable Long id) {
        idiomaService.deleteIdioma(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Idioma> getIdiomaById(@PathVariable Long id) {
        return ResponseEntity.ok(idiomaService.getIdiomaById(id));
    }

    @GetMapping
    public ResponseEntity<List<Idioma>> getAllIdiomas() {
        return ResponseEntity.ok(idiomaService.getAllIdiomas());
    }
}
