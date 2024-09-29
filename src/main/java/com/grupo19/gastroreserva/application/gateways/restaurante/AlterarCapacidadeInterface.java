package com.grupo19.gastroreserva.application.gateways.restaurante;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public interface AlterarCapacidadeInterface {
    Restaurante alterarCapacidade(Long id, Integer capacidade);
}
