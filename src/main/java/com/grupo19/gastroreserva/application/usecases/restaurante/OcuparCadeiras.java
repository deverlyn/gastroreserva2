package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.OcuparCadeirasInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public class OcuparCadeiras {

    private final OcuparCadeirasInterface ocuparCadeiras;

    public OcuparCadeiras(OcuparCadeirasInterface ocuparCadeiras) {
        this.ocuparCadeiras = ocuparCadeiras;
    }

    public Restaurante ocuparCadeiras(Long id, Integer quantidade){
        return ocuparCadeiras.ocuparCadeiras(id, quantidade);
    }
}
