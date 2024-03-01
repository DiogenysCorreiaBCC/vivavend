package com.api.vivavend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Venda;

/**
 * Interface de repositório para a entidade Venda.
 * Esta interface estende JpaRepository fornecendo operações CRUD básicas para a entidade Venda.
 * 
 * @author Ismael
 */
@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID>{

}
