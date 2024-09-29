package com.grupo19.gastroreserva.infra.persistence.restaurante;

import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Restaurante")
public class RestauranteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @Column(name = "tipo_de_cozinha")
    private String tipoDeCozinha;

    @Column(name = "capacidade")
    private Integer capacidade;

    @Column(name = "cadeiras_disponiveis")
    private Integer cadeirasDisponiveis;

    @Column(name = "hora_abertura")
    private LocalTime horaAbertura;

    @Column(name = "hora_fechamento")
    private LocalTime horaFechamento;

    public RestauranteEntity(String nome,
                             EnderecoEntity endereco,
                             String tipoDeCozinha,
                             Integer capacidade,
                             Integer cadeirasDisponiveis,
                             LocalTime horaAbertura,
                             LocalTime horaFechamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = cadeirasDisponiveis;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }
}
