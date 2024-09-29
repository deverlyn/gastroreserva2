package com.grupo19.gastroreserva.application.gateways.avaliacao;

import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;

public interface RealizarAvaliacaoInterface {

    Avaliacao realizarAvaliacao(Long idCliente, Long idRestaurante, Avaliacao avaliacao);
}
