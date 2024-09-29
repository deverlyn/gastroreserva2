package com.grupo19.gastroreserva.infra.controller.reserva;

import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import com.grupo19.gastroreserva.infra.controller.restaurante.RestauranteDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaDTO(
        ClienteDTO cliente,
        RestauranteDTO restaurante,
        LocalTime horario,
        LocalDate data,
        Integer quantidade
) {
}
