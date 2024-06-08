package com.apicurriculo.apicurriculosb.entity;

import com.apicurriculo.apicurriculosb.dto.ExperienciaProfissionalDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "EXPERIENCIAS_PROFISSIONAIS")
@NoArgsConstructor
public class ExperienciaProfissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    @JsonBackReference
    private Curriculo curriculo;

    public ExperienciaProfissional(ExperienciaProfissionalDto experienciaProfissionalDto) {
        this.descricao = experienciaProfissionalDto.descricao();
    }
}
