package br.com.petz.cliente_pet.cliente.infra;

import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import br.com.petz.cliente_pet.cliente.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteIfraRepository - salva");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finaliza] ClienteIfraRepository - salva");
        return cliente;
    }

    @Override
    public List<Cliente> buscaTodosCLientes() {
        log.info("[inicia] ClienteIfraRepository - buscaTodosClientes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finaliza] ClienteIfraRepository - buscaTodosClientes");
        return todosClientes;
    }

    @Override
    public Cliente buscaClienteAtravesId(UUID idCliente) {

        log.info("[inicia] ClienteIfraRepository - buscaClienteAtravesId");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        log.info("[finaliza] ClienteIfraRepository - buscaClienteAtravesId");
        return cliente;

    }

    @Override
    public void deletaCliente(Cliente cliente) {
        log.info("[inicia] ClienteIfraRepository - deletaCliente");
        clienteSpringDataJPARepository.delete(cliente);
        log.info("[finaliza] ClienteIfraRepository - deletaCliente");

    }
}
