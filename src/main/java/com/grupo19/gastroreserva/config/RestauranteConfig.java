package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.gateways.restaurante.*;
import com.grupo19.gastroreserva.application.usecases.restaurante.*;
import com.grupo19.gastroreserva.infra.gateways.EnderecoMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RepositorioDeRestauranteJpa;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteConfig {

    @Bean
    AlterarEnderecoRestaurante alterarEnderecoRestaurante(AlterarEnderecoRestauranteInterface alterarEnderecoRestauranteInterface) {
        return new AlterarEnderecoRestaurante(alterarEnderecoRestauranteInterface);
    }

    @Bean
    AlterarCapacidade alterarCapacidadeRestaurante(AlterarCapacidadeInterface alterarCapacidadeInterface){
        return new AlterarCapacidade(alterarCapacidadeInterface);
    }

    @Bean
    CadastrarRestaurante cadastrarRestaurante(CadastrarRestauranteInterface cadastrarRestauranteInterface) {
        return new CadastrarRestaurante(cadastrarRestauranteInterface);
    }

    @Bean
    DesocuparCadeiras desocuparCadeiras(DesocuparCadeirasInterface desocuparCadeirasInterface) {
        return new DesocuparCadeiras(desocuparCadeirasInterface);
    }

    @Bean
    ExcluirRestaurante excluirRestaurante(ExcluirRestauranteInterface excluirRestauranteInterface) {
        return new ExcluirRestaurante(excluirRestauranteInterface);
    }

    @Bean
    ListarRestaurantes listarRestaurantes(ListarRestaurantesInterface listarRestaurantesInterface) {
        return new ListarRestaurantes(listarRestaurantesInterface);
    }

    @Bean
    OcuparCadeiras cadeiras(OcuparCadeirasInterface cadeirasInterface) {
        return new OcuparCadeiras(cadeirasInterface);
    }

    @Bean
    RepositorioDeRestauranteJpa criaRepositorioDeRestauranteJpa(RestauranteRepository restauranteRepository,
                                                                EnderecoRepository enderecoRepository,
                                                                RestauranteMapper restauranteMapper,
                                                                EnderecoMapper enderecoMapper){
        return new RepositorioDeRestauranteJpa(restauranteRepository, enderecoRepository, restauranteMapper, enderecoMapper);
    }

    @Bean
    EnderecoMapper criarEnderecoMapper(){ return new EnderecoMapper(); }

    @Bean
    RestauranteMapper criaRestauranteMapper() { return new RestauranteMapper(); }

}
