package com.grupo19.gastroreserva.infra.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    RestauranteMapper restauranteMapper = new RestauranteMapper();

    public ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getRestaurantes().stream().map(restauranteMapper::toEntity).collect(Collectors.toList())
              );
    }

    public Cliente toDomain(ClienteEntity entity) {
        return new Cliente(entity.getCpf(),
                entity.getNome(),
                entity.getEmail(),
                entity.getRestaurante().stream().map(restauranteMapper::toDomain).collect(Collectors.toList()));
    }
}
