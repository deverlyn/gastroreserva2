package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ListarAvaliacoesDoClienteInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;

import java.util.List;

public class ListarAvaliacoesDoCliente {

    private final ListarAvaliacoesDoClienteInterface listarAvaliacoesDoClienteInterface;

    public ListarAvaliacoesDoCliente(ListarAvaliacoesDoClienteInterface listarAvaliacoesDoClienteInterface) {
        this.listarAvaliacoesDoClienteInterface = listarAvaliacoesDoClienteInterface;
    }

    public List<Avaliacao> listarAvaliacoesDoCliente(Long id) {
        return listarAvaliacoesDoClienteInterface.listarAvaliacoesDoCliente(id);
    }
}
