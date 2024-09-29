package com.grupo19.gastroreserva.application.gateways.restaurante;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.util.List;

public interface ListarRestaurantesInterface {

    List<Restaurante> listarRestaurantes();
}
