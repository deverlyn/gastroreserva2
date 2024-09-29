package com.grupo19.gastroreserva.domain.entities.reserva;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;


public class Reserva {
    private Long id;
    private Cliente cliente;
    private Restaurante restaurante;
    private LocalTime horario;
    private LocalDate data;
    private Integer quantidade;

    public Reserva(Cliente cliente, Restaurante restaurante, LocalTime horario, LocalDate data, Integer quantidade) {

        this.cliente = cliente;
        this.restaurante = restaurante;
        this.horario = horario;
        this.data = data;
        this.quantidade = quantidade;
        this.restaurante.setCadeirasDisponiveis(quantidade);
    }

    public Reserva(LocalTime horario, LocalDate data, Integer quantidade) {

        this.horario = horario;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Reserva() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {

        if(quantidade > restaurante.getCadeirasDisponiveis()){
            throw new IllegalArgumentException("Quantidade excede a capacidade disponível do restaurante");
        }

        if(horario.isBefore(restaurante.getHoraAbertura()) ||
                horario.isAfter(restaurante.getHoraFechamento())){
            throw new IllegalArgumentException("Horario incompativel com o funcionamento do restaurante");
        }

        this.restaurante = restaurante;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {

        if(horario.isBefore(restaurante.getHoraAbertura()) ||
                horario.isAfter(restaurante.getHoraFechamento())){
            throw new IllegalArgumentException("Horario incompativel com o funcionamento do restaurante");
        }

        this.horario = horario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
