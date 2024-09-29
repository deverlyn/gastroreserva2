package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.gateways.reserva.*;
import com.grupo19.gastroreserva.application.usecases.reserva.*;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;
import com.grupo19.gastroreserva.infra.gateways.reserva.ReservaMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RepositorioDeRestauranteJpa;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaConfig {

    @Bean
    AlterarDataReserva alterarDataReserva(AlterarDataReservaInterface alterarDataReservaInterface) {
        return new AlterarDataReserva(alterarDataReservaInterface);
    }

    @Bean
    AlterarHorarioReserva alterarHorarioReserva(AlterarHorarioReservaInterface alterarHorarioReservaInterface) {
        return new AlterarHorarioReserva(alterarHorarioReservaInterface);
    }

    @Bean
    CancelarReserva cancelarReserva(CancelarReservaInterface cancelarReservaInterface) {
        return new CancelarReserva(cancelarReservaInterface);
    }

    @Bean
    ListarReservasDoCliente listarReservasDoCliente(ListarReservasDoClienteInterface listarReservasInterface) {
        return new ListarReservasDoCliente(listarReservasInterface);
    }

    @Bean
    ListarTodasAsReservas listarTodasAsReservas(ListarTodasAsReservasInterface listarTodasAsReservasInterface) {
        return new ListarTodasAsReservas(listarTodasAsReservasInterface);
    }

    @Bean
    RealizarReserva realizarReserva(RealizarReservaInterface realizarReservaInterface) {
        return new RealizarReserva(realizarReservaInterface);
    }

    @Bean
    RepositorioDeReservaJpa criaRepositorioDeReserva(ReservaRepository repositorioDeReserva,
                                                     ClienteRepository clienteRepository,
                                                     RestauranteRepository restauranteRepository,
                                                     ReservaMapper reservaMapper,
                                                     ClienteMapper clienteMapper,
                                                     RestauranteMapper restauranteMapper,
                                                     RepositorioDeRestauranteJpa repositorioDeRestauranteJPA) {
        return new RepositorioDeReservaJpa(
                repositorioDeReserva,
                reservaMapper,
                clienteRepository,
                restauranteRepository,
                clienteMapper,
                restauranteMapper,
                repositorioDeRestauranteJPA);
    }

    @Bean
    ClienteMapper clienteMapper(ClienteRepository clienteRepository) { return new ClienteMapper(); }

    @Bean
    RestauranteMapper restauranteMapper(RestauranteRepository restauranteRepository) { return new RestauranteMapper(); }

    @Bean
    ReservaMapper criarMapper(){ return new ReservaMapper(); }
}
