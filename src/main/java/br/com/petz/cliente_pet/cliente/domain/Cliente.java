package br.com.petz.cliente_pet.cliente.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
//dados e comportamentos no mesmo lugar
public class Cliente {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       @Column(name= "id", updatable = false, unique = true, nullable = false)
       private UUID idCliente;
       @NotBlank
       private String nomeCompleto;

       @Email
       @NotBlank
       private String email;

       @NotBlank
       private String celular;
       private String telefone;
       private Sexo sexo;
       @NotNull
       private LocalDate dataNascimento;

       @CPF
       private String cpf;

       @NotNull
       private Boolean aceitaTermos;

       private LocalDateTime dataHoraDoCadastro;
       private LocalDateTime dataHoraDaUltimaAlteracao;

    public Cliente(String nomeCompleto, String email, String celular, String telefone, Sexo sexo, LocalDate dataNascimento, String cpf, Boolean aceitaTermos) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.aceitaTermos = aceitaTermos;

        this.dataHoraDoCadastro=LocalDateTime.now();
        this.dataHoraDaUltimaAlteracao=LocalDateTime.now();
        
    }
}
