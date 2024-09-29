package com.grupo19.gastroreserva.infra.persistence.cliente;

import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class ClienteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "cliente_restaurante",
    joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name = "restaurante_id"))
    private List<RestauranteEntity> restaurante;

    public ClienteEntity(String cpf, String nome, String email, List<RestauranteEntity> restaurante) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.restaurante = restaurante;
    }
}

