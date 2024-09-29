package com.grupo19.gastroreserva.infra.gateways.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.*;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RepositorioDeRestauranteJpa;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaEntity;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeReservaJpa implements
        AlterarDataReservaInterface,
        AlterarHorarioReservaInterface,
        CancelarReservaInterface,
        ListarReservasDoClienteInterface,
        ListarTodasAsReservasInterface,
        RealizarReservaInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final ClienteRepository clienteRepository;
    private final RestauranteRepository restauranteRepository;
    private final ClienteMapper clienteMapper;
    private final RestauranteMapper restauranteMapper;
    private final RepositorioDeRestauranteJpa repositorioDeRestauranteJpa;

    public RepositorioDeReservaJpa(ReservaRepository reservaRepository, ReservaMapper reservaMapper, ClienteRepository clienteRepository, RestauranteRepository restauranteRepository, ClienteMapper clienteMapper, RestauranteMapper restauranteMapper, RepositorioDeRestauranteJpa repositorioDeRestauranteJpa) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
        this.clienteRepository = clienteRepository;
        this.restauranteRepository = restauranteRepository;
        this.clienteMapper = clienteMapper;
        this.restauranteMapper = restauranteMapper;
        this.repositorioDeRestauranteJpa = repositorioDeRestauranteJpa;
    }

    @Override
    public Reserva alterarDataReserva(Long id, LocalDate data) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Reserva não encontrado"));
        reservaEntity.setData(data);
        return reservaMapper.toDomain(reservaRepository.save(reservaEntity));
    }

    @Override
    public Reserva alterarHorarioReserva(Long id, LocalTime horario) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Reserva não encontrado"));
        Reserva reserva = reservaMapper.toDomain(reservaEntity);
        reserva.setHorario(horario);
        ReservaEntity reservaAlterada = reservaMapper.toEntity(reserva);
        reservaAlterada.setId(reservaEntity.getId());
        reservaAlterada.setCliente(reservaEntity.getCliente());
        reservaAlterada.setRestaurante(reservaEntity.getRestaurante());
        return reservaMapper.toDomain(reservaRepository.save(reservaAlterada));
    }

    @Override
    public void cancelarReserva(Long id) {
        ReservaEntity entity = reservaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Reserva não encontrado"));
        reservaRepository.delete(entity);
    }

    @Override
    public List<Reserva> listarReservasDoCliente(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        return reservaRepository.findAllByClienteId(id)
                .stream()
                .map(reservaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> listarTodasAsReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(reservaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Reserva realizarReserva(Reserva reserva, Long idCliente, Long idRestaurante) {
        ClienteEntity clienteEntity = clienteRepository.findById(idCliente).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado"));
        RestauranteEntity restauranteEntity = restauranteRepository.findById(idRestaurante).orElseThrow(() ->
                new IllegalArgumentException("Restaurante não encontrado"));
        clienteEntity.getRestaurante().add(restauranteEntity);
        Cliente clienteDomain = clienteMapper.toDomain(clienteEntity);
        Restaurante restauranteDomain = restauranteMapper.toDomain(restauranteEntity);
        reserva.setCliente(clienteDomain);
        reserva.setRestaurante(restauranteDomain);
        ReservaEntity reservaEntity = reservaMapper.toEntity(reserva);
        reservaEntity.setCliente(clienteEntity);
        reservaEntity.setRestaurante(restauranteEntity);
        repositorioDeRestauranteJpa.ocuparCadeiras(idRestaurante, reserva.getQuantidade());
        clienteRepository.save(clienteEntity);
        return reservaMapper.toDomain(reservaRepository.save(reservaEntity));
    }
}
