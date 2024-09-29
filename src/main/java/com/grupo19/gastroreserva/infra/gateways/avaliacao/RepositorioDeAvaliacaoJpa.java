package com.grupo19.gastroreserva.infra.gateways.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.*;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoRepository;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeAvaliacaoJpa implements
        EditarAvaliacaoInterface,
        ExcluirAvaliacaoInterface,
        RealizarAvaliacaoInterface,
        ListarAvaliacoesDoClienteInterface,
        ListarTodasAsAvaliacoesInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final ClienteRepository clienteRepository;
    private final RestauranteRepository restauranteRepository;
    private final AvaliacaoMapper avaliacaoMapper;
    private final ClienteMapper clienteMapper;
    private final RestauranteMapper restauranteMapper;

    public RepositorioDeAvaliacaoJpa(AvaliacaoRepository avaliacaoRepository, ClienteRepository clienteRepository, RestauranteRepository restauranteRepository, AvaliacaoMapper avaliacaoMapper, ClienteMapper clienteMapper, RestauranteMapper restauranteMapper) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.clienteRepository = clienteRepository;
        this.restauranteRepository = restauranteRepository;
        this.avaliacaoMapper = avaliacaoMapper;
        this.clienteMapper = clienteMapper;
        this.restauranteMapper = restauranteMapper;
    }

    @Override
    public Avaliacao editarAvaliacao(Long id, Avaliacao avaliacao) {
        AvaliacaoEntity antigaAvaliacao = avaliacaoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Avaliação não encontrado"));
        AvaliacaoEntity novaAvaliacao = avaliacaoMapper.toEntity(avaliacao);
        novaAvaliacao.setId(id);
        novaAvaliacao.setCliente(antigaAvaliacao.getCliente());
        novaAvaliacao.setRestaurante(antigaAvaliacao.getRestaurante());
        return avaliacaoMapper.toDomain(avaliacaoRepository.save(antigaAvaliacao));
    }

    @Override
    public void excluirAvaliacao(Long id) {
        AvaliacaoEntity entity = avaliacaoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Avaliação não encontrado"));
        avaliacaoRepository.delete(entity);
    }

    @Override
    public Avaliacao realizarAvaliacao(Long idCliente, Long idRestaurante, Avaliacao avaliacao) {
        ClienteEntity clienteEntity = clienteRepository.findById(idCliente).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        RestauranteEntity restauranteEntity = restauranteRepository.findById(idRestaurante).orElseThrow(() ->
                new IllegalArgumentException("Restaurante não encontrado"));

        avaliacao.setCliente(clienteMapper.toDomain(clienteEntity));
        avaliacao.setRestaurante(restauranteMapper.toDomain(restauranteEntity));


        if(clienteEntity.getRestaurante().stream().anyMatch(restauranteEntity::equals)) {
            AvaliacaoEntity entity = avaliacaoMapper.toEntity(avaliacao);
            entity.setCliente(clienteEntity);
            entity.setRestaurante(restauranteEntity);
            avaliacaoRepository.save(entity);
            return avaliacaoMapper.toDomain(entity);
        } else {
            throw new IllegalArgumentException("O Cliente nunca frequentou esse restaurante");
        }
    }

    @Override
    public List<Avaliacao> listarAvaliacoesDoCliente(Long id) {
        return avaliacaoRepository.findByClienteId(id)
                .stream()
                .map(avaliacaoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Avaliacao> listarTodasAvaliacoes() {
        return avaliacaoRepository.findAll()
                .stream()
                .map(avaliacaoMapper::toDomain)
                .collect(Collectors.toList());
    }
}
