package com.grupo19.gastroreserva.infra.controller.avaliacao;

import com.grupo19.gastroreserva.application.usecases.avaliacao.*;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private final EditarAvaliacao editarAvaliacao;
    private final ExcluirAvaliacao excluirAvaliacao;
    private final ListarAvaliacoesDoCliente listarAvaliacoesDoCliente;
    private final ListarTodasAsAvaliacoes listarTodasAsAvaliacoes;
    private final RealizarAvaliacao realizarAvaliacao;

    public AvaliacaoController(EditarAvaliacao editarAvaliacao, ExcluirAvaliacao excluirAvaliacao, ListarAvaliacoesDoCliente listarAvaliacoesDoCliente, ListarTodasAsAvaliacoes listarTodasAsAvaliacoes, RealizarAvaliacao realizarAvaliacao) {
        this.editarAvaliacao = editarAvaliacao;
        this.excluirAvaliacao = excluirAvaliacao;
        this.listarAvaliacoesDoCliente = listarAvaliacoesDoCliente;
        this.listarTodasAsAvaliacoes = listarTodasAsAvaliacoes;
        this.realizarAvaliacao = realizarAvaliacao;
    }

    @GetMapping("/{id}")
    public List<AvaliacaoDTO> listarAvaliacoesDoCliente(@PathVariable Long id) {
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
        listarAvaliacoesDoCliente.listarAvaliacoesDoCliente(id)
                .forEach(v -> avaliacoes.add(new AvaliacaoDTO(
                        v.getCliente(),
                        v.getRestaurante(),
                        v.getNota(),
                        v.getComentario(),
                        v.getData())));
        return avaliacoes;
    }

    @GetMapping
    public List<AvaliacaoDTO> listarTodasAsAvaliacoes() {
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
        listarTodasAsAvaliacoes.listarTodasAsAvaliacoes()
                .forEach(v -> avaliacoes.add(new AvaliacaoDTO(
                        v.getCliente(),
                        v.getRestaurante(),
                        v.getNota(),
                        v.getComentario(),
                        v.getData())));
        return avaliacoes;
    }

    @PostMapping("{idCliente}/{idRestaurante}")
    public AvaliacaoDTO realizarAvaliacao(@PathVariable Long idCliente,
                                          @PathVariable Long idRestaurante,
                                          @RequestBody AvaliacaoDTO avaliacaoDTO) {

        Avaliacao novaAvaliacao = realizarAvaliacao.realizarAvaliacao(idCliente,
                idRestaurante,
                new Avaliacao(avaliacaoDTO.nota(),
                        avaliacaoDTO.comentario(),
                        avaliacaoDTO.data()));

        return new AvaliacaoDTO(novaAvaliacao.getCliente(),
                novaAvaliacao.getRestaurante(),
                novaAvaliacao.getNota(),
                novaAvaliacao.getComentario(),
                novaAvaliacao.getData());
    }

    @PatchMapping("/alterar/{id}")
    public AvaliacaoDTO editarAvaliacao(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacaoAlterada = editarAvaliacao.editarAvaliacao(id,
                new Avaliacao(avaliacaoDTO.nota(),
                        avaliacaoDTO.comentario(),
                        avaliacaoDTO.data()));

        return new AvaliacaoDTO(avaliacaoAlterada.getCliente(),
                avaliacaoAlterada.getRestaurante(),
                avaliacaoAlterada.getNota(),
                avaliacaoAlterada.getComentario(),
                avaliacaoAlterada.getData());
    }

    @DeleteMapping("/{id}")
    public void excluirAvaliacao(@PathVariable Long id) {
        excluirAvaliacao.excluirAvaliacao(id);
    }
}
