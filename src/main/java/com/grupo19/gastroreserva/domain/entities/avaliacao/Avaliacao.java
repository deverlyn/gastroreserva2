package com.grupo19.gastroreserva.domain.entities.avaliacao;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;

public class Avaliacao {

    private Cliente cliente;
    private Restaurante restaurante;
    private Integer nota;
    private String comentario;
    private LocalDate data;

    public Avaliacao(Cliente cliente, Restaurante restaurante, Integer nota, String comentario, LocalDate data) {
        if(cliente == null || restaurante == null || nota == null || data == null){
            throw new IllegalArgumentException("Os campos cliente, restaurante, nota e data são obrigatórios");
        }
        if(nota < 0 || nota > 5){
            throw new IllegalArgumentException("Nota inválida");
        }

        this.cliente = cliente;
        this.restaurante = restaurante;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }

    public Avaliacao(Integer nota, String comentario, LocalDate data) {

        if(nota == null || data == null){
            throw new IllegalArgumentException("Os campos cliente, restaurante, nota e data são obrigatórios");
        }
        if(nota < 0 || nota > 5){
            throw new IllegalArgumentException("Nota inválida");
        }

        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }

    public Avaliacao() {
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

        if(!cliente.getRestaurantes().contains(restaurante)){
            throw new IllegalArgumentException("O Cliente nunca frequentou este restaurante");
        }

        this.restaurante = restaurante;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
