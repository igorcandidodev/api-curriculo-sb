package com.apicurriculo.apicurriculosb.entity;

import com.apicurriculo.apicurriculosb.dto.CurriculoDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "CURRICULOS")
@NoArgsConstructor
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "curriculo")
    @JsonManagedReference
    private InformacaoPessoal informacaoPessoal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculo")
    @JsonManagedReference
    private List<ExperienciaProfissional> experienciaProfissional;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculo")
    @JsonManagedReference
    private List<Ferramenta> ferramenta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculo")
    @JsonManagedReference
    private List<Idioma> idioma;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculo")
    @JsonManagedReference
    private List<FormacaoAcademica> formacaoAcademica;

    public Curriculo(CurriculoDto curriculoDto) {
        this.informacaoPessoal = new InformacaoPessoal(curriculoDto.informacaoPessoal());
        informacaoPessoal.setCurriculo(this);
        this.experienciaProfissional = curriculoDto.experienciaProfissional().stream().map(exp -> {
            ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional(exp);
            experienciaProfissional.setCurriculo(this);
            return experienciaProfissional;
        }).collect(Collectors.toList());
        this.ferramenta = curriculoDto.ferramenta().stream().map(c -> {
            Ferramenta ferramenta = new Ferramenta(c);
            ferramenta.setCurriculo(this);
            return ferramenta;
        }).collect(Collectors.toList());
        this.idioma = curriculoDto.idioma().stream().map(i -> {
            Idioma idioma = new Idioma(i);
            idioma.setCurriculo(this);
            return idioma;
        }).collect(Collectors.toList());
        this.formacaoAcademica = curriculoDto.formacaoAcademica().stream().map(f -> {
            FormacaoAcademica formacaoAcademica = new FormacaoAcademica(f);
            formacaoAcademica.setCurriculo(this);
            return formacaoAcademica;
        }).collect(Collectors.toList());
    }

}
