package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ListarClientesInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;

import java.util.List;


public class ListarClientes {

    private final ListarClientesInterface listarClientesInterface;

    public ListarClientes(ListarClientesInterface listarClientesInterface) {
        this.listarClientesInterface = listarClientesInterface;
    }

    public List<Cliente> listarCliente(){
        return listarClientesInterface.listarClientes();
    }
}
