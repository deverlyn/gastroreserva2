package com.grupo19.gastroreserva.application.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;

public interface AlterarNomeClienteInterface {
    Cliente alterarNomeCliente(Long id, String nome);
}
