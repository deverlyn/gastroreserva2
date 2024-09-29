package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.ListarTodasAsReservasInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

import java.util.List;

public class ListarTodasAsReservas {

    private final ListarTodasAsReservasInterface listarTodasAsReservas;

    public ListarTodasAsReservas(ListarTodasAsReservasInterface listarTodasAsReservas) {
        this.listarTodasAsReservas = listarTodasAsReservas;
    }

    public List<Reserva> listarTodasAsReservas() {
        return listarTodasAsReservas.listarTodasAsReservas();
    }
}
