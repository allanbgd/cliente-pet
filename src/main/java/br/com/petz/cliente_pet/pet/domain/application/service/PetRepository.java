package br.com.petz.cliente_pet.pet.domain.application.service;

import br.com.petz.cliente_pet.pet.domain.Pet;

public interface PetRepository {
    Pet salvaPet(Pet pet);
}
