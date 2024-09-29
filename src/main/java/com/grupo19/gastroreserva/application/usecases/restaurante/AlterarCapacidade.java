package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.AlterarCapacidadeInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public class AlterarCapacidade {
    private final AlterarCapacidadeInterface alterarCapacidade;

    public AlterarCapacidade(AlterarCapacidadeInterface alterarCapacidade) {
        this.alterarCapacidade = alterarCapacidade;
    }

    public Restaurante alterarCapacidade(Long id, Integer capacidade) {
        return alterarCapacidade.alterarCapacidade(id, capacidade);
    }
}
