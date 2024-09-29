package com.grupo19.gastroreserva.infra.controller.cliente;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.util.List;

public record ClienteDTO(
         String cpf,
         String nome,
         String email,
         List<Restaurante>restaurantes) {
}
