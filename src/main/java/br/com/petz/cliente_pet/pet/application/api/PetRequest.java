package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.pet.domain.Porte;
import br.com.petz.cliente_pet.pet.domain.SexoPet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import lombok.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Value
public class PetRequest {
    @NotBlank
    private String nomePet;
    private Porte porte;
    @NotNull
    private TipoPet tipo;
    private String microchip;
    @NotBlank
    private String raca;
    @NotNull
    private SexoPet sexo;
    private String pelagemCor;
    @NotNull
    private LocalDate dataNascimento;
    private String rga;
    private Integer peso;
}
