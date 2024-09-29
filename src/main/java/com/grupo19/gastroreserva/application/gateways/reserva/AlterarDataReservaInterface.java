package com.grupo19.gastroreserva.application.gateways.reserva;

import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

import java.time.LocalDate;

public interface AlterarDataReservaInterface {

    Reserva alterarDataReserva(Long id, LocalDate data);
}
