package com.api.vivavend.services;

import java.util.Optional;
import java.util.UUID;

import com.api.vivavend.model.Avaliacao;

/**
 * Interface que define os métodos para operações relacionadas a avaliações.
 */

public interface AvaliacaoServiceInterface {
    Avaliacao salvarAvaliacao(Avaliacao avaliacao);
    void deletarAvaliacao(Avaliacao avaliacao);
    public Optional<Avaliacao> buscarAvaliacaoPorId(UUID id);
}
