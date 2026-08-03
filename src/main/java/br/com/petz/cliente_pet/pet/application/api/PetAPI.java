package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.cliente_pet.cliente.application.api.ClienteListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {

        @PostMapping
        @ResponseStatus(code = HttpStatus.CREATED)
        PetResponse postPet(@PathVariable UUID idCliente,
                            @Valid @RequestBody PetRequest petRequest);


        @GetMapping
        @ResponseStatus(code = HttpStatus.OK)
        List<PetClienteListResponse> getPetsDoClienteComId(@PathVariable UUID idCliente);

        @GetMapping(value = "/{idPet}")
        @ResponseStatus(code = HttpStatus.OK)
        PetDetalhadoResponse getPetAtravesId(@PathVariable UUID idCliente, @PathVariable UUID idPet);



}
