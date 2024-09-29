package com.grupo19.gastroreserva.infra.persistence.reserva;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    List<ReservaEntity> findAllByClienteId(Long id);
}
