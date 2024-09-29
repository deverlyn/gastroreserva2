package com.grupo19.gastroreserva.domain.entities.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;

import java.time.LocalTime;

public class Restaurante {
    private String nome;
    private Endereco endereco;
    private String tipoDeCozinha;
    private Integer capacidade;
    private Integer cadeirasDisponiveis;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;

    public Restaurante(String nome,
                       Endereco endereco,
                       String tipoDeCozinha,
                       Integer capacidade,
                       Integer cadeirasDisponiveis,
                       LocalTime horaAbertura,
                       LocalTime horaFechamento) {

        if(cadeirasDisponiveis > capacidade){
            throw new IllegalArgumentException("Não é possível declarar mais cadeiras que sua capacidade");
        }

        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = cadeirasDisponiveis;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }

    public Restaurante() {}

    public Restaurante(String nome,
                       String tipoDeCozinha,
                       Integer capacidade,
                       Integer cadeirasDisponiveis,
                       LocalTime horaAbertura,
                       LocalTime horaFechamento) {

        if(cadeirasDisponiveis > capacidade){
            throw new IllegalArgumentException("Não é possível declarar mais cadeiras que sua capacidade");
        }

        this.nome = nome;
        this.tipoDeCozinha = tipoDeCozinha;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = cadeirasDisponiveis;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTipoDeCozinha() {
        return tipoDeCozinha;
    }

    public void setTipoDeCozinha(String tipoDeCozinha) {
        this.tipoDeCozinha = tipoDeCozinha;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidadeNova) {
        int cadeirasOcupadas = this.capacidade - cadeirasDisponiveis;

        if(capacidadeNova <= cadeirasOcupadas) {
            throw new IllegalArgumentException("Não é possível diminuir a capacidade para menos ou igual à quantidade de cadeiras ocupadas atualmente");
        }
        this.capacidade = capacidadeNova;
        this.cadeirasDisponiveis = capacidade - cadeirasOcupadas;
    }

    public Integer getCadeirasDisponiveis() {
        return cadeirasDisponiveis;
    }


    public void setCadeirasDisponiveis(Integer cadeirasOcupadas) {
        this.cadeirasDisponiveis = cadeirasDisponiveis - cadeirasOcupadas;
    }
    public void ocuparCadeiras(Integer cadeirasOcupadas) {
        if (cadeirasOcupadas < 0 || cadeirasOcupadas > cadeirasDisponiveis) {
            throw new IllegalArgumentException("Número inválido de cadeiras para ocupar");
        }
        this.cadeirasDisponiveis -= cadeirasOcupadas;
    }

    public void desocuparCadeiras(Integer quantidade){
        if(quantidade > capacidade - cadeirasDisponiveis){
            throw new IllegalArgumentException("Impossível desocupar mais que " + (capacidade - cadeirasDisponiveis));
        }
        this.cadeirasDisponiveis += quantidade;
    }
}