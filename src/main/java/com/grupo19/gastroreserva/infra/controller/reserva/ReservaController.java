package com.grupo19.gastroreserva.infra.controller.reserva;

import com.grupo19.gastroreserva.application.usecases.reserva.*;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import com.grupo19.gastroreserva.infra.controller.restaurante.RestauranteDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final AlterarDataReserva alterarDataReserva;
    private final AlterarHorarioReserva alterarHorarioReserva;
    private final CancelarReserva cancelarReserva;
    private final ListarReservasDoCliente listarReservasDoCliente;
    private final ListarTodasAsReservas listarTodasAsReservas;
    private final RealizarReserva realizarReserva;

    public ReservaController(AlterarDataReserva alterarDataReserva, AlterarHorarioReserva alterarHorarioReserva, CancelarReserva cancelarReserva, ListarReservasDoCliente listarReservasDoCliente, ListarTodasAsReservas listarTodasAsReservas, RealizarReserva realizarReserva) {
        this.alterarDataReserva = alterarDataReserva;
        this.alterarHorarioReserva = alterarHorarioReserva;
        this.cancelarReserva = cancelarReserva;
        this.listarReservasDoCliente = listarReservasDoCliente;
        this.listarTodasAsReservas = listarTodasAsReservas;
        this.realizarReserva = realizarReserva;
    }

    @GetMapping("/{id}")
    public List<ReservaDTO> listarReservasDoCliente(@PathVariable Long id){
        List<ReservaDTO> reservas = new ArrayList<>();
        listarReservasDoCliente.listarReservasDoCliente(id)
                .forEach(reserva -> reservas.add(new ReservaDTO(
                        new ClienteDTO(reserva.getCliente().getCpf(),
                                reserva.getCliente().getNome(),
                                reserva.getCliente().getEmail(),
                                reserva.getCliente().getRestaurantes()),
                        new RestauranteDTO(reserva.getRestaurante().getNome(),
                                reserva.getRestaurante().getEndereco(),
                                reserva.getRestaurante().getTipoDeCozinha(),
                                reserva.getRestaurante().getCapacidade(),
                                reserva.getRestaurante().getCadeirasDisponiveis(),
                                reserva.getRestaurante().getHoraAbertura(),
                                reserva.getRestaurante().getHoraFechamento()),
                        reserva.getHorario(),
                        reserva.getData(),
                        reserva.getQuantidade())));

        return reservas;
    }

    @GetMapping
    public List<ReservaDTO> listarTodasAsReservas(){
        List<ReservaDTO> reservas = new ArrayList<>();
        listarTodasAsReservas.listarTodasAsReservas()
                .forEach(reserva -> reservas.add(new ReservaDTO(
                        new ClienteDTO(reserva.getCliente().getCpf(),
                                reserva.getCliente().getNome(),
                                reserva.getCliente().getEmail(),
                                reserva.getCliente().getRestaurantes()),
                        new RestauranteDTO(reserva.getRestaurante().getNome(),
                                reserva.getRestaurante().getEndereco(),
                                reserva.getRestaurante().getTipoDeCozinha(),
                                reserva.getRestaurante().getCapacidade(),
                                reserva.getRestaurante().getCadeirasDisponiveis(),
                                reserva.getRestaurante().getHoraAbertura(),
                                reserva.getRestaurante().getHoraFechamento()),
                        reserva.getHorario(),
                        reserva.getData(),
                        reserva.getQuantidade())));

        return reservas;
    }

    @PostMapping("/{idCliente}/{idRestaurante}")
    public ReservaDTO fazerReserva(@RequestBody ReservaDTO reservaDTO,
                                   @PathVariable Long idCliente,
                                   @PathVariable Long idRestaurante){
        Reserva reserva = realizarReserva.realizarReserva(new Reserva(
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()), idCliente, idRestaurante);
        return new ReservaDTO(
                new ClienteDTO(
                        reserva.getCliente().getCpf(),
                        reserva.getCliente().getNome(),
                        reserva.getCliente().getEmail(),
                        reserva.getCliente().getRestaurantes()),
                new RestauranteDTO(
                        reserva.getRestaurante().getNome(),
                        reserva.getRestaurante().getEndereco(),
                        reserva.getRestaurante().getTipoDeCozinha(),
                        reserva.getRestaurante().getCapacidade(),
                        reserva.getRestaurante().getCadeirasDisponiveis(),
                        reserva.getRestaurante().getHoraAbertura(),
                        reserva.getRestaurante().getHoraFechamento()),
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    @PatchMapping("/data/{id}/{novaData}")
    public ReservaDTO alterarData(@PathVariable Long id, @PathVariable LocalDate novaData){
        Reserva reserva = alterarDataReserva.alterarDataReserva(id, novaData);
        return new ReservaDTO(
                new ClienteDTO(
                        reserva.getCliente().getCpf(),
                        reserva.getCliente().getNome(),
                        reserva.getCliente().getEmail(),
                        reserva.getCliente().getRestaurantes()),
                new RestauranteDTO(
                        reserva.getRestaurante().getNome(),
                        reserva.getRestaurante().getEndereco(),
                        reserva.getRestaurante().getTipoDeCozinha(),
                        reserva.getRestaurante().getCapacidade(),
                        reserva.getRestaurante().getCadeirasDisponiveis(),
                        reserva.getRestaurante().getHoraAbertura(),
                        reserva.getRestaurante().getHoraFechamento()),
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    @PatchMapping("/hora/{id}/{novaHora}")
    public ReservaDTO alterarHora(@PathVariable Long id, @PathVariable LocalTime novaHora){
        Reserva reserva = alterarHorarioReserva.alterarHorarioReserva(id, novaHora);
        return new ReservaDTO(
                new ClienteDTO(
                        reserva.getCliente().getCpf(),
                        reserva.getCliente().getNome(),
                        reserva.getCliente().getEmail(),
                        reserva.getCliente().getRestaurantes()),
                new RestauranteDTO(
                        reserva.getRestaurante().getNome(),
                        reserva.getRestaurante().getEndereco(),
                        reserva.getRestaurante().getTipoDeCozinha(),
                        reserva.getRestaurante().getCapacidade(),
                        reserva.getRestaurante().getCadeirasDisponiveis(),
                        reserva.getRestaurante().getHoraAbertura(),
                        reserva.getRestaurante().getHoraFechamento()),
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    @DeleteMapping("/{id}")
    public void excluirReserva(@PathVariable Long id){
        cancelarReserva.cancelarReserva(id);
    }

}
