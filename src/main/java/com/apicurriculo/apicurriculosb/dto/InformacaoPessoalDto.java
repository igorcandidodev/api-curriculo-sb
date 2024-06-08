package com.apicurriculo.apicurriculosb.dto;

import jakarta.validation.constraints.Email;

public record InformacaoPessoalDto(
        @Email
        String email,
        String nomeCompleto,
        String cargo,
        String cidade,
        String estado,
        String pais
) {
}
