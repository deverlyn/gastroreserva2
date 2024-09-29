package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.CancelarReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

public class CancelarReserva {

    private final CancelarReservaInterface cancelarReservaInterface;

    public CancelarReserva(CancelarReservaInterface cancelarReservaInterface) {
        this.cancelarReservaInterface = cancelarReservaInterface;
    }

    public void cancelarReserva(Long id) {
        cancelarReservaInterface.cancelarReserva(id);
    }
}
