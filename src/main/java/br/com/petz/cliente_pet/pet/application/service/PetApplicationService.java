package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.cliente.application.service.ClienteService;
import br.com.petz.cliente_pet.pet.application.api.*;
import br.com.petz.cliente_pet.pet.application.repository.PetRepository;
import br.com.petz.cliente_pet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
    private final ClienteService clienteService;
    private final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] petApplicationService - criaPet");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[finaliza] petApplicationService - criaPet");
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[inicia] petApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComId(idCliente);
        log.info("[finaliza] petApplicationService - buscaPetsDoClienteComId");

        return PetClienteListResponse.converte(petsDoCliente);
    }

    @Override
    public PetDetalhadoResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[inicia] petApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPetPeloId(idPet);
        log.info("[finaliza] petApplicationService - buscaPetsDoClienteComId");

        return new PetDetalhadoResponse(pet);
    }

    @Override
    public void deletaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[inicia] petApplicationService - deletaPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPetPeloId(idPet);
        petRepository.deletaPet(pet);
        log.info("[finaliza] petApplicationService - deletaPetDoClienteComId");

    }

    @Override
    public void alteracaoPetDoClienteComID(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest) {
        log.info("[inicia] petApplicationService - deletaPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPetPeloId(idPet);
        pet.altera(petAlteracaoRequest);
        petRepository.salvaPet(pet);
        log.info("[finaliza] petApplicationService - deletaPetDoClienteComId");

    }
}
