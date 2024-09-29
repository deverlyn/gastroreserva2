package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.DesocuparCadeirasInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public class DesocuparCadeiras {
    private final DesocuparCadeirasInterface desocuparCadeiras;

    public DesocuparCadeiras(DesocuparCadeirasInterface desocuparCadeiras) {
        this.desocuparCadeiras = desocuparCadeiras;
    }

    public Restaurante desocuparCadeiras(Long id, Integer quantidade){
        return desocuparCadeiras.desocuparCadeiras(id, quantidade);
    }
}
