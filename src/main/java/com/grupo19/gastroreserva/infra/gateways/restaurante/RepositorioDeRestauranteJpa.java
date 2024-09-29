package com.grupo19.gastroreserva.infra.gateways.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.*;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.EnderecoMapper;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeRestauranteJpa implements
        AlterarEnderecoRestauranteInterface,
        CadastrarRestauranteInterface,
        ExcluirRestauranteInterface,
        ListarRestaurantesInterface,
        OcuparCadeirasInterface,
        DesocuparCadeirasInterface,
        AlterarCapacidadeInterface{

    private final RestauranteRepository restauranteRepository;
    private final EnderecoRepository enderecoRepository;
    private final RestauranteMapper restauranteMapper;
    private final EnderecoMapper enderecoMapper;

    public RepositorioDeRestauranteJpa(RestauranteRepository restauranteRepository, EnderecoRepository enderecoRepository, RestauranteMapper restauranteMapper, EnderecoMapper enderecoMapper) {
        this.restauranteRepository = restauranteRepository;
        this.enderecoRepository = enderecoRepository;
        this.restauranteMapper = restauranteMapper;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public Restaurante alterarEnderecoRestaurante(Long id, Endereco endereco) {
        RestauranteEntity restauranteEntity = restauranteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Restaurante não encontrado"));
        EnderecoEntity enderecoAntigo = enderecoRepository.findOne(Example.of(restauranteEntity.getEndereco())).orElse(null);

        Restaurante restaurante = restauranteMapper.toDomain(restauranteEntity);
        restaurante.setEndereco(endereco);
        RestauranteEntity salvar = restauranteMapper.toEntity(restaurante);
        EnderecoEntity enderecoEntity = enderecoRepository.save(salvar.getEndereco());
        salvar.setId(id);
        salvar.setEndereco(enderecoEntity);
        restauranteRepository.save(salvar);
        if(enderecoAntigo != null){
            enderecoRepository.delete(enderecoAntigo);
        }
        return restauranteMapper.toDomain(salvar);
    }

    @Override
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        RestauranteEntity restauranteEntity = restauranteMapper.toEntity(restaurante);
        EnderecoEntity enderecoSalvo = enderecoRepository.save(restauranteEntity.getEndereco());
        restauranteEntity.setEndereco(enderecoSalvo);
        return restauranteMapper.toDomain(restauranteRepository.save(restauranteEntity));
    }

    @Override
    public void excluirRestaurante(Long id) {
        RestauranteEntity entity = restauranteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Restaurante não encontrado"));
        EnderecoEntity endereco = enderecoRepository.findOne(Example.of(entity.getEndereco())).orElse(null);
        restauranteRepository.delete(entity);
        if(endereco != null){
            enderecoRepository.delete(endereco);
        }
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll()
                .stream()
                .map(restauranteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Restaurante ocuparCadeiras(Long id , Integer quantidade) {
        RestauranteEntity entity = restauranteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Restaurante não encontrado"));
        EnderecoEntity enderecoSalvo = enderecoRepository.findOne(Example.of(entity.getEndereco())).orElseThrow(() ->
                new IllegalArgumentException("Endereço não encontrado não encontrado"));
        entity.setEndereco(enderecoSalvo);
        Restaurante restaurante = restauranteMapper.toDomain(entity);
        restaurante.ocuparCadeiras(quantidade);
        RestauranteEntity salvo = restauranteMapper.toEntity(restaurante);
        salvo.setId(id);
        salvo.getEndereco().setId(enderecoSalvo.getId());
        return restauranteMapper.toDomain(restauranteRepository.save(salvo));
    }

    @Override
    public Restaurante desocuparCadeiras(Long id, Integer quantidade) {
        RestauranteEntity entity = restauranteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Restaurante não encontrado"));
        EnderecoEntity enderecoSalvo = enderecoRepository.findOne(Example.of(entity.getEndereco())).orElseThrow(() ->
                new IllegalArgumentException("Endereço não encontrado não encontrado"));
        entity.setEndereco(enderecoSalvo);
        Restaurante restaurante = restauranteMapper.toDomain(entity);
        restaurante.desocuparCadeiras(quantidade);
        RestauranteEntity salvo = restauranteMapper.toEntity(restaurante);
        salvo.setId(id);
        salvo.getEndereco().setId(enderecoSalvo.getId());
        return restauranteMapper.toDomain(restauranteRepository.save(salvo));
    }

    @Override
    public Restaurante alterarCapacidade(Long id, Integer capacidade) {
        RestauranteEntity entity = restauranteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Restaurante não encontrado"));
        EnderecoEntity enderecoSalvo = enderecoRepository.findOne(Example.of(entity.getEndereco())).orElseThrow(() ->
                new IllegalArgumentException("Endereço não encontrado não encontrado"));
        entity.setEndereco(enderecoSalvo);
        Restaurante restaurante = restauranteMapper.toDomain(entity);
        restaurante.setCapacidade(capacidade);
        RestauranteEntity salvo = restauranteMapper.toEntity(restaurante);
        salvo.setId(id);
        salvo.getEndereco().setId(enderecoSalvo.getId());
        return restauranteMapper.toDomain(restauranteRepository.save(salvo));
    }
}
