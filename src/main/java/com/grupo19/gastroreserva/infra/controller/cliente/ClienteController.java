package com.grupo19.gastroreserva.infra.controller.cliente;

import com.grupo19.gastroreserva.application.usecases.cliente.*;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final AlterarEmailCliente alterarEmailCliente;
    private final AlterarNomeCliente alterarNomeCliente;
    private final CadastrarCliente cadastrarCliente;
    private final ExcluirCliente excluirCliente;
    private final ListarClientes listarClientes;

    public ClienteController(AlterarEmailCliente alterarEmailCliente, AlterarNomeCliente alterarNomeCliente, CadastrarCliente cadastrarCliente, ExcluirCliente excluirCliente, ListarClientes listarClientes) {
        this.alterarEmailCliente = alterarEmailCliente;
        this.alterarNomeCliente = alterarNomeCliente;
        this.cadastrarCliente = cadastrarCliente;
        this.excluirCliente = excluirCliente;
        this.listarClientes = listarClientes;
    }

    @PostMapping
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO dto) {
        Cliente salvo = cadastrarCliente.cadastrarCliente(new Cliente(dto.cpf(), dto.nome(), dto.email(), dto.restaurantes()));
        return new ClienteDTO(salvo.getCpf(), salvo.getNome(), salvo.getEmail(), salvo.getRestaurantes());
    }

    @PatchMapping("/email/{id}/{email}")
    public ClienteDTO alterarEmailCliente(@PathVariable Long id, @PathVariable String email) {
        Cliente salvo = alterarEmailCliente.alterarEmailCliente(id, email);
        return new ClienteDTO(salvo.getCpf(), salvo.getNome(), salvo.getEmail(), salvo.getRestaurantes());
    }

    @PatchMapping("/nome/{id}/{nome}")
    public ClienteDTO alterarNomeCliente(@PathVariable Long id, @PathVariable String nome) {
        Cliente salvo = alterarNomeCliente.alterarNomeCliente(id, nome);
        return new ClienteDTO(salvo.getCpf(), salvo.getNome(), salvo.getEmail(), salvo.getRestaurantes());
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        excluirCliente.excluirCliente(id);
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        listarClientes.listarCliente().forEach(v -> clientesDTO.add(new ClienteDTO(
                v.getCpf(),
                v.getNome(),
                v.getEmail(),
                v.getRestaurantes())));
        return clientesDTO;
    }
}
