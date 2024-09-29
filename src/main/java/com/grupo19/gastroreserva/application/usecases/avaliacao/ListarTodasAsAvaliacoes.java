package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ListarTodasAsAvaliacoesInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;

import java.util.List;

public class ListarTodasAsAvaliacoes {
    private final ListarTodasAsAvaliacoesInterface listarTodasAsAvaliacoes;

    public ListarTodasAsAvaliacoes(ListarTodasAsAvaliacoesInterface listarTodasAsAvaliacoes) {
        this.listarTodasAsAvaliacoes = listarTodasAsAvaliacoes;
    }

    public List<Avaliacao> listarTodasAsAvaliacoes() {
        return listarTodasAsAvaliacoes.listarTodasAvaliacoes();
    }
}
