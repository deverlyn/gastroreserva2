package com.grupo19.gastroreserva.application.gateways.avaliacao;

import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;

import java.util.List;

public interface ListarAvaliacoesDoClienteInterface {

    List<Avaliacao> listarAvaliacoesDoCliente(Long id);

}
