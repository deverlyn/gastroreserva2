package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.ListarReservasDoClienteInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

import java.util.List;

public class ListarReservasDoCliente {

    private final ListarReservasDoClienteInterface listarReservasDoClienteInterface;

    public ListarReservasDoCliente(ListarReservasDoClienteInterface listarReservasDoClienteInterface) {
        this.listarReservasDoClienteInterface = listarReservasDoClienteInterface;
    }

    public List<Reserva> listarReservasDoCliente(Long id) {
        return listarReservasDoClienteInterface.listarReservasDoCliente(id);
    }
}
