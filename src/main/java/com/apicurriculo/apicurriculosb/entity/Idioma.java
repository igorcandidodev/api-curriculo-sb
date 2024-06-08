package com.apicurriculo.apicurriculosb.entity;

import com.apicurriculo.apicurriculosb.dto.IdiomaDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "IDIOMAS")
@NoArgsConstructor
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nivel;

    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    @JsonBackReference
    private Curriculo curriculo;

    public Idioma(IdiomaDto idiomaDto) {
        this.nome = idiomaDto.nome();
        this.nivel = idiomaDto.nivel();
    }
}
