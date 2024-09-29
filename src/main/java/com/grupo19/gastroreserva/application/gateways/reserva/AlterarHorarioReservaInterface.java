package com.grupo19.gastroreserva.application.gateways.reserva;

import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

import java.time.LocalTime;

public interface AlterarHorarioReservaInterface {

    Reserva alterarHorarioReserva(Long id, LocalTime horario);
}
