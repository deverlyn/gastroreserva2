package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.gateways.cliente.*;
import com.grupo19.gastroreserva.application.usecases.cliente.*;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    AlterarEmailCliente alterarEmailCliente(AlterarEmailClienteInterface alterarEmailCliente){
        return new AlterarEmailCliente(alterarEmailCliente);
    }

    @Bean
    AlterarNomeCliente alterarNomeCliente(AlterarNomeClienteInterface alterarNomeCliente){
        return new AlterarNomeCliente(alterarNomeCliente);
    }

    @Bean
    CadastrarCliente cadastrarCliente(CadastrarClienteInterface cadastrarCliente ){
        return new CadastrarCliente(cadastrarCliente);
    }

    @Bean
    ExcluirCliente excluirCliente(ExcluirClienteInterface excluirCliente){
        return new ExcluirCliente(excluirCliente);
    }

    @Bean
    ListarClientes listarClientes(ListarClientesInterface listarClientes){
        return new ListarClientes(listarClientes);
    }

    @Bean
    RepositorioDeClienteJpa criarRepositorioDeClienteJpa(ClienteRepository clienteRepository, ClienteMapper clienteMapper){
        return new RepositorioDeClienteJpa(clienteRepository, clienteMapper);
    }

    @Bean
    ClienteMapper criaClienteMapper(){ return new ClienteMapper(); }

}
