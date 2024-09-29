package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.RealizarAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;

public class RealizarAvaliacao {

    private final RealizarAvaliacaoInterface realizarAvaliacaoInterface;

    public RealizarAvaliacao(RealizarAvaliacaoInterface realizarAvaliacaoInterface) {
        this.realizarAvaliacaoInterface = realizarAvaliacaoInterface;
    }

    public Avaliacao realizarAvaliacao(Long idCliente, Long idRestaurante, Avaliacao avaliacao){
        return realizarAvaliacaoInterface.realizarAvaliacao(idCliente, idRestaurante, avaliacao);
    }
}
