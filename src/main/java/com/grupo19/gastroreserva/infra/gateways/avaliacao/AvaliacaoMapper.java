package com.grupo19.gastroreserva.infra.gateways.avaliacao;

import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;

public class AvaliacaoMapper {

    ClienteMapper clienteMapper = new ClienteMapper();
    RestauranteMapper restauranteMapper = new RestauranteMapper();

    public AvaliacaoEntity toEntity(Avaliacao avaliacao) {
        ClienteEntity clienteEntity = clienteMapper.toEntity(avaliacao.getCliente());
        RestauranteEntity restaurante = restauranteMapper.toEntity(avaliacao.getRestaurante());
        restauranteMapper.toEntity(avaliacao.getRestaurante());
        return new AvaliacaoEntity(clienteEntity,
                restaurante,
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getData());
    }


    public Avaliacao toDomain(AvaliacaoEntity entity) {
        Restaurante restaurante = restauranteMapper.toDomain(entity.getRestaurante());
        Cliente cliente = clienteMapper.toDomain(entity.getCliente());
        return new Avaliacao(cliente,
                restaurante,
                entity.getNota(),
                entity.getComentario(),
                entity.getData());
    }
}
