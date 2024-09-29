package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;

public class ExcluirAvaliacao {

    private final ExcluirAvaliacaoInterface excluirAvaliacaoInterface;

    public ExcluirAvaliacao(ExcluirAvaliacaoInterface excluirAvaliacaoInterface) {
        this.excluirAvaliacaoInterface = excluirAvaliacaoInterface;
    }

    public void excluirAvaliacao(Long id) {
        excluirAvaliacaoInterface.excluirAvaliacao(id);
    }
}
