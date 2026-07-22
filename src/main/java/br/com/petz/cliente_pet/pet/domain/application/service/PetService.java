package br.com.petz.cliente_pet.pet.domain.application.service;

import br.com.petz.cliente_pet.pet.domain.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.domain.application.api.PetResponse;

import java.util.UUID;

public interface PetService {
    PetResponse criaPet(UUID idCliente, PetRequest petRequest);
}
