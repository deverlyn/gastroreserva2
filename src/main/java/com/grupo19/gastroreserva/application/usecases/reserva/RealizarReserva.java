package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.RealizarReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

public class RealizarReserva {

    private final RealizarReservaInterface realizarReservaInterface;

    public RealizarReserva(RealizarReservaInterface realizarReservaInterface) {
        this.realizarReservaInterface = realizarReservaInterface;
    }

    public Reserva realizarReserva(Reserva reserva, Long idCliente, Long idRestaurante) {
        return realizarReservaInterface.realizarReserva(reserva, idCliente, idRestaurante);
    }
}
