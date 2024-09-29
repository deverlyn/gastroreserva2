package com.grupo19.gastroreserva.infra.persistence.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
    List<AvaliacaoEntity> findByClienteId(Long id);

    AvaliacaoEntity findByClienteIdAndRestauranteId(Long idCliente, Long idRestaurante);
}