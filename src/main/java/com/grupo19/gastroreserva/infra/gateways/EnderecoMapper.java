package com.grupo19.gastroreserva.infra.gateways;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;

public class EnderecoMapper {

    public EnderecoEntity toEntity(Endereco endereco) {
        return new EnderecoEntity(endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado());
    }
    public Endereco toDomain(EnderecoEntity endereco) {
        return new Endereco(endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado());
    }
}
