package com.api.vivavend.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Avaliacao;
import com.api.vivavend.repository.AvaliacaoRepository;

import jakarta.transaction.Transactional;

/**
 * Serviço responsável por lidar com operações relacionadas a avaliações.
 * Implementa a interface AvaliacaoServiceInterface.
 * 
 * @author Ismael
 */

@Service
public class AvaliacaoService implements AvaliacaoServiceInterface{
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
    /**
     * Salva uma avaliação.
     * 
     * @param avaliacao A avaliação a ser salva.
     * @return A avaliação salva.
     */
	@Override
    @Transactional
    public Avaliacao salvarAvaliacao(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }
	
    /**
     * Deleta uma avaliação.
     * 
     * @param avaliacao A avaliação a ser deletada.
     */
	@Override
	@Transactional
    public void deletarAvaliacao(Avaliacao avaliacao) {
		avaliacaoRepository.delete(avaliacao);
	}
	
    /**
     * Busca uma avaliação pelo seu ID.
     * 
     * @param id O ID da avaliação a ser buscada.
     * @return Um Optional contendo a avaliação, se encontrada.
     */
	@Override
	public Optional<Avaliacao> buscarAvaliacaoPorId(UUID id) {
        return avaliacaoRepository.findById(id);
    }
}
