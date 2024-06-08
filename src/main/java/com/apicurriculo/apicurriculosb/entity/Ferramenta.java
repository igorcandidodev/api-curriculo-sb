package com.apicurriculo.apicurriculosb.entity;

import com.apicurriculo.apicurriculosb.dto.FerramentaDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "FERRAMENTAS")
@NoArgsConstructor
public class Ferramenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    @JsonBackReference
    private Curriculo curriculo;

    public Ferramenta(FerramentaDto ferramentaDto) {
        this.nome = ferramentaDto.nome();
    }
}
