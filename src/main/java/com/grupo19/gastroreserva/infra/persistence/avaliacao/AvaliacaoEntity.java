package com.grupo19.gastroreserva.infra.persistence.avaliacao;

import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Avaliacao")
public class AvaliacaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteEntity restaurante;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "data")
    private LocalDate data;

    public AvaliacaoEntity(ClienteEntity cliente, RestauranteEntity restaurante, Integer nota, String comentario, LocalDate data) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }

    public AvaliacaoEntity(Integer nota, String comentario, LocalDate data) {
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }
}
