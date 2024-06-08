package com.apicurriculo.apicurriculosb.dto;

import jakarta.validation.Valid;

import java.util.List;

public record CurriculoDto(
        InformacaoPessoalDto informacaoPessoal,
        @Valid
        List<FormacaoAcademicaDto> formacaoAcademica,
        @Valid
        List<ExperienciaProfissionalDto> experienciaProfissional,
        @Valid
        List<IdiomaDto> idioma,
        @Valid
        List<FerramentaDto> ferramenta
) {
}
