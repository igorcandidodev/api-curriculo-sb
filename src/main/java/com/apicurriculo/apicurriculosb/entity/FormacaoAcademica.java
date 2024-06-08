package com.apicurriculo.apicurriculosb.entity;

import com.apicurriculo.apicurriculosb.dto.FormacaoAcademicaDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "FORMACOES_ACADEMICAS")
@NoArgsConstructor
public class FormacaoAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;

    private String instituicao;

    private String dataInicio;

    private String dataFim;

    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    @JsonBackReference
    private Curriculo curriculo;

    public FormacaoAcademica(FormacaoAcademicaDto formacaoAcademicaDto) {
        this.curso = formacaoAcademicaDto.curso();
        this.instituicao = formacaoAcademicaDto.instituicao();
        this.dataInicio = formacaoAcademicaDto.dataInicio();
        this.dataFim = formacaoAcademicaDto.dataFim();
    }
}
