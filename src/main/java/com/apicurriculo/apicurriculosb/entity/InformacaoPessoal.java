package com.apicurriculo.apicurriculosb.entity;

import com.apicurriculo.apicurriculosb.dto.InformacaoPessoalDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "INFORMACOES_PESSOAIS")
@NoArgsConstructor
public class InformacaoPessoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nomeCompleto;

    private String cargo;

    private String cidade;

    private String estado;

    private String pais;

    @OneToOne
    @JoinColumn(name = "curriculo_id")
    @JsonBackReference
    private Curriculo curriculo;

    public InformacaoPessoal(InformacaoPessoalDto informacaoPessoalDto) {
        this.email = informacaoPessoalDto.email();
        this.nomeCompleto = informacaoPessoalDto.nomeCompleto();
        this.cargo = informacaoPessoalDto.cargo();
        this.cidade = informacaoPessoalDto.cidade();
        this.estado = informacaoPessoalDto.estado();
        this.pais = informacaoPessoalDto.pais();
    }
}
