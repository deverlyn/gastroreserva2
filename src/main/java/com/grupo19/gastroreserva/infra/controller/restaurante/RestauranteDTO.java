package com.grupo19.gastroreserva.infra.controller.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;

import java.time.LocalTime;

public record RestauranteDTO(
        String nome,
        Endereco endereco,
        String tipoDeCozinha,
        Integer capacidade,
        Integer cadeirasDisponiveis,
        LocalTime horaAbertura,
        LocalTime horaFechamento
) {
}
