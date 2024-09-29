package com.grupo19.gastroreserva.domain.entities.cliente;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private List<Restaurante> restaurantes;

    public Cliente(String cpf, String nome, String email, List<Restaurante> restaurantes) {

        if(cpf == null || cpf.isBlank() || nome == null || nome.isBlank() || email == null || email.isBlank()){
            throw new IllegalArgumentException("Campo Obrigatório está nulo ou vazio");
        }

        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException("CPF no formato inválido");
        }

        if(!email.contains("@") && !email.contains(".com")){}

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.restaurantes = (restaurantes != null) ? restaurantes : new ArrayList<>();
    }

    public Cliente() {
        this.restaurantes = new ArrayList<>();
    }

    public Cliente(String cpf, String nome, String email) {
        this(cpf, nome, email, new ArrayList<>());
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void addRestaurante(Restaurante restaurante) {
        this.restaurantes.add(restaurante);
    }


}
