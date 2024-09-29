package com.grupo19.gastroreserva.application.gateways.restaurante;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public interface OcuparCadeirasInterface {
    Restaurante ocuparCadeiras(Long id, Integer quantidade);
}
