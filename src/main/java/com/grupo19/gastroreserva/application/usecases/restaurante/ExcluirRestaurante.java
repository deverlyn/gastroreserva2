package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public class ExcluirRestaurante {

    private final ExcluirRestauranteInterface excluirRestauranteInterface;

    public ExcluirRestaurante(ExcluirRestauranteInterface excluirRestauranteInterface) {
        this.excluirRestauranteInterface = excluirRestauranteInterface;
    }

    public void excluirRestaurante(Long id) {
        excluirRestauranteInterface.excluirRestaurante(id);
    }
}
