package com.api.vivavend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Produto;

/**
 * Interface de repositório para a entidade Produto.
 * Esta interface estende JpaRepository fornecendo operações CRUD básicas para a entidade Produto.
 * 
 * @author Ismael
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
	
}