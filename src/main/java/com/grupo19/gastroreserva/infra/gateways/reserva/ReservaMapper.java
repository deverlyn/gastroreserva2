package com.grupo19.gastroreserva.infra.gateways.reserva;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;

public class ReservaMapper {
    ClienteMapper clienteMapper = new ClienteMapper();
    RestauranteMapper restauranteMapper = new RestauranteMapper();

    public ReservaEntity toEntity(Reserva reserva) {
        ClienteEntity clienteEntity = clienteMapper.toEntity(reserva.getCliente());
        RestauranteEntity restauranteEntity = restauranteMapper.toEntity(reserva.getRestaurante());
        return new ReservaEntity(clienteEntity,
                restauranteEntity,
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    public Reserva toDomain(ReservaEntity reservaEntity) {
        Cliente cliente = clienteMapper.toDomain(reservaEntity.getCliente());
        Restaurante restaurante = restauranteMapper.toDomain(reservaEntity.getRestaurante());
        return new Reserva(cliente,
                restaurante,
                reservaEntity.getHorario(),
                reservaEntity.getData(),
                reservaEntity.getQuantidade());
    }
}
