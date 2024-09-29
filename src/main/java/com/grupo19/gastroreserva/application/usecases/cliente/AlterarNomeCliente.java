package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarNomeClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;

public class AlterarNomeCliente {

    private final AlterarNomeClienteInterface alterarNomeCliente;

    public AlterarNomeCliente(AlterarNomeClienteInterface alterarNomeCliente) {
        this.alterarNomeCliente = alterarNomeCliente;
    }

    public Cliente alterarNomeCliente(Long id, String nome) {
        return alterarNomeCliente.alterarNomeCliente(id, nome);
    }
}
