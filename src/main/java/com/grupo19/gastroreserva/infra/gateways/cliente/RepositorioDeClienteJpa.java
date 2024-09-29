package com.grupo19.gastroreserva.infra.gateways.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.*;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeClienteJpa implements AlterarEmailClienteInterface,
        CadastrarClienteInterface,
        ExcluirClienteInterface,
        ListarClientesInterface,
        AlterarNomeClienteInterface{

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    public RepositorioDeClienteJpa(ClienteRepository clienteRepository, ClienteMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    @Override
    public Cliente alterarEmailCliente(Long id, String email) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        entity.setEmail(email);
        clienteRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        clienteRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public void excluirCliente(Long id) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        clienteRepository.delete(entity);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Cliente alterarNomeCliente(Long id, String nome) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        entity.setNome(nome);
        clienteRepository.save(entity);
        return mapper.toDomain(entity);
    }
}
