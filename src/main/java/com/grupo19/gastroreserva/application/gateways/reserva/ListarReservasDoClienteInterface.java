package com.grupo19.gastroreserva.application.gateways.reserva;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

import java.util.List;

public interface ListarReservasDoClienteInterface {

    List<Reserva> listarReservasDoCliente(Long id);
}
