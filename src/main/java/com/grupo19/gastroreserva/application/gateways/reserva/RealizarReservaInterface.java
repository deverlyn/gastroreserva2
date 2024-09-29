package com.grupo19.gastroreserva.application.gateways.reserva;

import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

public interface RealizarReservaInterface {

    Reserva realizarReserva(Reserva reserva, Long idCliente, Long idRestaurante);
}
