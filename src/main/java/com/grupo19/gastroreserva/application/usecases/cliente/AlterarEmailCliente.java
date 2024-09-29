package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;

public class AlterarEmailCliente implements AlterarEmailClienteInterface{

    private final AlterarEmailClienteInterface alterarEmailClienteInterface;

    public AlterarEmailCliente(AlterarEmailClienteInterface alterarEmailClienteInterface) {
        this.alterarEmailClienteInterface = alterarEmailClienteInterface;
    }

    public Cliente alterarEmailCliente(Long id, String email) {
        return alterarEmailClienteInterface.alterarEmailCliente(id, email);
    }
}
