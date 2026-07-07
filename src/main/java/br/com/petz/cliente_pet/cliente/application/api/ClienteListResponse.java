package br.com.petz.cliente_pet.cliente.application.api;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String celular;
    private String email;

}
