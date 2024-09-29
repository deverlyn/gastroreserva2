package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;


public class ExcluirCliente implements ExcluirClienteInterface {

    private final ExcluirClienteInterface excluirClienteInterface;

    public ExcluirCliente(ExcluirClienteInterface excluirClienteInterface) {
        this.excluirClienteInterface = excluirClienteInterface;
    }

    public void excluirCliente(Long id) {
       excluirClienteInterface.excluirCliente(id);
    }
}
