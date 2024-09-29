package com.grupo19.gastroreserva.infra.persistence.reserva;

import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Reserva")
public class ReservaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteEntity restaurante;

    @Column(name = "horario")
    private LocalTime horario;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "quantidade")
    private Integer quantidade;

    public ReservaEntity(ClienteEntity cliente, RestauranteEntity restaurante, LocalTime horario, LocalDate data, Integer quantidade) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.horario = horario;
        this.data = data;
        this.quantidade = quantidade;
    }
}
