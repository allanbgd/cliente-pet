package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.pet.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PetService {
    PetResponse criaPet(UUID idCliente, PetRequest petRequest);

    List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente);

    PetDetalhadoResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet);

    void deletaPetDoClienteComId(UUID idCliente, UUID idPet);

    void alteracaoPetDoClienteComID(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest);
}
