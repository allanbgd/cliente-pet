package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
    private final PetService petService;

    @Override
    public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] petController - postPet");
        log.info("[idCliente] {}", idCliente);
        PetResponse pet = petService.criaPet(idCliente, petRequest);
        log.info("[finaliza] petController - postPet");

        return pet;
    }

    @Override
    public List<PetClienteListResponse> getPetsDoClienteComId(UUID idCliente) {
        log.info("[inicia] petController - getPetsDoClienteComId");
        log.info("[idCliente] {}", idCliente);
        List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoClienteComId(idCliente);
        log.info("[finaliza] petController - getPetsDoClienteComId");

        return petsDoCliente;
    }

    @Override
    public PetDetalhadoResponse getPetAtravesId(UUID idCliente, UUID idPet) {
        log.info("[inicia] petController - getPetAtravesId");
        log.info("[idCliente] {}", idCliente);
        log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
        
        log.info("[finaliza] petController - getPetAtravesId");


        return null;
    }
}
