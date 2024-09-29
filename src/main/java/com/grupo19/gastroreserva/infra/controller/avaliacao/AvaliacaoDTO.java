package com.grupo19.gastroreserva.infra.controller.avaliacao;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;

public record AvaliacaoDTO(Cliente cliente,
        Restaurante restaurante,
        Integer nota,
        String comentario,
        LocalDate data
) {
}
