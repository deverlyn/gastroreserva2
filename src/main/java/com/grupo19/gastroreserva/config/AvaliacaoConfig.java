package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.gateways.avaliacao.*;
import com.grupo19.gastroreserva.application.usecases.avaliacao.*;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.AvaliacaoMapper;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.RepositorioDeAvaliacaoJpa;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoRepository;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliacaoConfig {

    @Bean
    EditarAvaliacao editarAvaliacao(EditarAvaliacaoInterface repositorio){
        return new EditarAvaliacao(repositorio);
    };

    @Bean
    ExcluirAvaliacao excluirAvaliacao(ExcluirAvaliacaoInterface repositorio){
        return new ExcluirAvaliacao(repositorio);
    }

    @Bean
    ListarTodasAsAvaliacoes listarTodasAvaliacoes(ListarTodasAsAvaliacoesInterface repositorio){
        return new ListarTodasAsAvaliacoes(repositorio);
    }

    @Bean
    ListarAvaliacoesDoCliente listarAvaliacoesDoCliente(ListarAvaliacoesDoClienteInterface repositorio){
        return new ListarAvaliacoesDoCliente(repositorio);
    }

    @Bean
    RealizarAvaliacao realizarAvaliacao(RealizarAvaliacaoInterface repositorio){
        return new RealizarAvaliacao(repositorio);
    }

    @Bean
    RepositorioDeAvaliacaoJpa criaRepositorioDeAvaliacaoJpa(AvaliacaoRepository avaliacaoRepository,
                                                            ClienteRepository clienteRepository,
                                                            RestauranteRepository restauranteRepository,
                                                            AvaliacaoMapper avaliacaoMapper,
                                                            ClienteMapper clienteMapper,
                                                            RestauranteMapper restauranteMapper){
        return new RepositorioDeAvaliacaoJpa(avaliacaoRepository,
                clienteRepository,
                restauranteRepository,
                avaliacaoMapper,
                clienteMapper,
                restauranteMapper);
    }

    @Bean
    AvaliacaoMapper criaMapper(){ return new AvaliacaoMapper(); }
}
