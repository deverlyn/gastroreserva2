package com.grupo19.gastroreserva.application.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;

import java.util.List;

public interface ListarClientesInterface {

    List<Cliente> listarClientes();
}
