package com.grupo19.gastroreserva.application.gateways.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public interface AlterarEnderecoRestauranteInterface {

    Restaurante alterarEnderecoRestaurante(Long id, Endereco endereco);
}
