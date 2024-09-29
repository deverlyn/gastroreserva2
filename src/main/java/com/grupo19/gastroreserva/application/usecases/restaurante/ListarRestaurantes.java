package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.util.List;

public class ListarRestaurantes {

    private final ListarRestaurantesInterface listarRestaurantesInterface;

    public ListarRestaurantes(ListarRestaurantesInterface listarRestaurantesInterface) {
        this.listarRestaurantesInterface = listarRestaurantesInterface;
    }

    public List<Restaurante> listarRestaurantes() {
        return listarRestaurantesInterface.listarRestaurantes();
    }
}
