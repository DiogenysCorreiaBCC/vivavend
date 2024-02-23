package com.api.vivavend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Avaliacao;
import com.api.vivavend.repository.AvaliacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class AvaliacaoService implements AvaliacaoServiceInterface{
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Override
    @Transactional
    public Avaliacao saveAvaliacao(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }
	
	@Override
	@Transactional
    public void deleteAvaliacao(Avaliacao avaliacao) {
		avaliacaoRepository.delete(avaliacao);
	}
}
