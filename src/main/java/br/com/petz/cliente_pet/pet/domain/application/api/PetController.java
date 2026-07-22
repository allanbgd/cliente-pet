package br.com.petz.cliente_pet.pet.domain.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
public class PetController implements PetAPI {


    @Override
    public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] petController - postPet");
        log.info("[idCliente] {}", idCliente);
        log.info("[finaliza] petController - postPet");

        return null;
    }
}
