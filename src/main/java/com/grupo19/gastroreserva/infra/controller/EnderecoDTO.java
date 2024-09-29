package com.grupo19.gastroreserva.infra.controller;

public record EnderecoDTO(
        Long id,
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado
) {
}
