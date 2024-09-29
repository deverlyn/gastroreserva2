package com.grupo19.gastroreserva.infra.controller.restaurante;

import com.grupo19.gastroreserva.application.usecases.restaurante.*;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.EnderecoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    private final AlterarEnderecoRestaurante alterarEnderecoRestaurante;
    private final AlterarCapacidade alterarCapacidade;
    private final CadastrarRestaurante cadastrarRestaurante;
    private final DesocuparCadeiras desocuparCadeiras;
    private final ExcluirRestaurante excluirRestaurante;
    private final ListarRestaurantes listarRestaurantes;
    private final OcuparCadeiras ocuparCadeiras;

    public RestauranteController(AlterarEnderecoRestaurante alterarEnderecoRestaurante, AlterarCapacidade alterarCapacidade, CadastrarRestaurante cadastrarRestaurante, DesocuparCadeiras desocuparCadeiras, ExcluirRestaurante excluirRestaurante, ListarRestaurantes listarRestaurantes, OcuparCadeiras ocuparCadeiras) {
        this.alterarEnderecoRestaurante = alterarEnderecoRestaurante;
        this.alterarCapacidade = alterarCapacidade;
        this.cadastrarRestaurante = cadastrarRestaurante;
        this.desocuparCadeiras = desocuparCadeiras;
        this.excluirRestaurante = excluirRestaurante;
        this.listarRestaurantes = listarRestaurantes;
        this.ocuparCadeiras = ocuparCadeiras;
    }

    @GetMapping
    public List<RestauranteDTO> listarRestaurantes() {
        List<RestauranteDTO> restaurantesDTO = new ArrayList<>();
        listarRestaurantes.listarRestaurantes().forEach(restaurante -> restaurantesDTO.add(new RestauranteDTO(restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoDeCozinha(),
                restaurante.getCapacidade(),
                restaurante.getCadeirasDisponiveis(),
                restaurante.getHoraAbertura(),
                restaurante.getHoraFechamento())));
        return restaurantesDTO;
    }

    @PostMapping
    public RestauranteDTO cadastrarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        Restaurante salvo = cadastrarRestaurante.cadastrarRestaurante(new Restaurante(restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.capacidade(),
                restauranteDTO.cadeirasDisponiveis(),
                restauranteDTO.horaAbertura(),
                restauranteDTO.horaFechamento()));

        return new RestauranteDTO(salvo.getNome(),
                salvo.getEndereco(),
                salvo.getTipoDeCozinha(),
                salvo.getCapacidade(),
                salvo.getCadeirasDisponiveis(),
                salvo.getHoraAbertura(),
                salvo.getHoraFechamento());
    }

    @PostMapping("/ocupar/{id}/{quantidade}")
    public RestauranteDTO ocuparCadeiras(@PathVariable Long id, @PathVariable int quantidade) {
        Restaurante salvo = ocuparCadeiras.ocuparCadeiras(id, quantidade);
        return new RestauranteDTO(salvo.getNome(),
                salvo.getEndereco(),
                salvo.getTipoDeCozinha(),
                salvo.getCapacidade(),
                salvo.getCadeirasDisponiveis(),
                salvo.getHoraAbertura(),
                salvo.getHoraFechamento());
    }

    @PostMapping("/desocupar/{id}/{quantidade}")
    public RestauranteDTO desocuparCadeiras(@PathVariable Long id, @PathVariable int quantidade) {
        Restaurante salvo = desocuparCadeiras.desocuparCadeiras(id, quantidade);
        return new RestauranteDTO(salvo.getNome(),
                salvo.getEndereco(),
                salvo.getTipoDeCozinha(),
                salvo.getCapacidade(),
                salvo.getCadeirasDisponiveis(),
                salvo.getHoraAbertura(),
                salvo.getHoraFechamento());
    }

    @PatchMapping("/capacidade/{id}/{capacidade}")
    public RestauranteDTO alterarCapacidadeAtual(@PathVariable Long id, @PathVariable int capacidade) {
        Restaurante salvo = alterarCapacidade.alterarCapacidade(id, capacidade);
        return new RestauranteDTO(salvo.getNome(),
                salvo.getEndereco(),
                salvo.getTipoDeCozinha(),
                salvo.getCapacidade(),
                salvo.getCadeirasDisponiveis(),
                salvo.getHoraAbertura(),
                salvo.getHoraFechamento());
    }

    @PatchMapping("/endereco/{id}")
    public RestauranteDTO alterarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        Restaurante salvo = alterarEnderecoRestaurante.alterarEnderecoRestaurante(id,
                new Endereco(enderecoDTO.cep(),
                        enderecoDTO.logradouro(),
                        enderecoDTO.numero(),
                        enderecoDTO.bairro(),
                        enderecoDTO.cidade(),
                        enderecoDTO.estado()));

        return new RestauranteDTO(salvo.getNome(),
                salvo.getEndereco(),
                salvo.getTipoDeCozinha(),
                salvo.getCapacidade(),
                salvo.getCadeirasDisponiveis(),
                salvo.getHoraAbertura(),
                salvo.getHoraFechamento());
    }

    @DeleteMapping("/{id}")
    public void excluirRestaurante(@PathVariable Long id) {
        excluirRestaurante.excluirRestaurante(id);
    }


}
