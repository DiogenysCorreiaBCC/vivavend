package com.api.vivavend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Avaliacao;

/**
 * Interface de repositório para a entidade Avaliacao.
 * Esta interface estende JpaRepository fornecendo operações CRUD básicas para a entidade Avaliacao.
 * 
 * @author Ismael
 */

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,UUID>{
	
}
