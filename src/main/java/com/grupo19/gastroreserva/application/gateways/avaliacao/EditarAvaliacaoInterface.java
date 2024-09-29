package com.grupo19.gastroreserva.application.gateways.avaliacao;

import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;

public interface EditarAvaliacaoInterface {
    Avaliacao editarAvaliacao(Long id, Avaliacao avaliacao);
}
