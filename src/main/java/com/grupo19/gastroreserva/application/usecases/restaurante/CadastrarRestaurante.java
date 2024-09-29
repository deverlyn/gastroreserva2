package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public class CadastrarRestaurante {

    private final CadastrarRestauranteInterface cadastrarRestauranteInterface;

    public CadastrarRestaurante(CadastrarRestauranteInterface cadastrarRestauranteInterface) {
        this.cadastrarRestauranteInterface = cadastrarRestauranteInterface;
    }

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        return cadastrarRestauranteInterface.cadastrarRestaurante(restaurante);
    }
}
