package com.apicurriculo.apicurriculosb.controller;

import com.apicurriculo.apicurriculosb.dto.InformacaoPessoalDto;
import com.apicurriculo.apicurriculosb.entity.InformacaoPessoal;
import com.apicurriculo.apicurriculosb.service.IInformacaoPessoalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informacao-pessoal")
public class InformacaoPessoalController {

    private final IInformacaoPessoalService informacaoPessoalService;

    @Autowired
    public InformacaoPessoalController(IInformacaoPessoalService informacaoPessoalService) {
        this.informacaoPessoalService = informacaoPessoalService;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<InformacaoPessoal> updateInformacaoPessoal(@PathVariable Long id, @RequestBody InformacaoPessoalDto InformacaoPessoalDto) {
        var informacaoPessoal = new InformacaoPessoal(InformacaoPessoalDto);

        return ResponseEntity.ok(informacaoPessoalService.updateInformacaoPessoal(id, informacaoPessoal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteInformacaoPessoal(@PathVariable Long id) {
        informacaoPessoalService.deleteInformacaoPessoal(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacaoPessoal> getInformacaoPessoalById(@PathVariable Long id) {
        return ResponseEntity.ok(informacaoPessoalService.getInformacaoPessoalById(id));
    }

    @GetMapping
    public ResponseEntity<List<InformacaoPessoal>> getAllInformacaoPessoal() {
        return ResponseEntity.ok(informacaoPessoalService.getAllInformacaoPessoal());
    }
}
