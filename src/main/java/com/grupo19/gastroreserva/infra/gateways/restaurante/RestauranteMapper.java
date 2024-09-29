package com.grupo19.gastroreserva.infra.gateways.restaurante;


import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.EnderecoMapper;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;

public class RestauranteMapper {

    EnderecoMapper enderecoMapper = new EnderecoMapper();

    public RestauranteEntity toEntity(Restaurante restaurante) {
        EnderecoEntity enderecoEntity = enderecoMapper.toEntity(restaurante.getEndereco());
        return new RestauranteEntity(restaurante.getNome(),
                enderecoEntity,
                restaurante.getTipoDeCozinha(),
                restaurante.getCapacidade(),
                restaurante.getCadeirasDisponiveis(),
                restaurante.getHoraAbertura(),
                restaurante.getHoraFechamento());
    }


    public Restaurante toDomain(RestauranteEntity entity) {
        Endereco endereco = enderecoMapper.toDomain(entity.getEndereco());
        return new Restaurante(entity.getNome(),
                endereco,
                entity.getTipoDeCozinha(),
                entity.getCapacidade(),
                entity.getCadeirasDisponiveis(),
                entity.getHoraAbertura(),
                entity.getHoraFechamento());
    }
}
