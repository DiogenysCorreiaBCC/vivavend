package com.api.vivavend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Endereco;

/**
 * Interface de repositório para a entidade Endereço.
 * Esta interface estende JpaRepository fornecendo operações CRUD básicas para a entidade Endereço.
 * 
 * @author Ismael
 */

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,UUID>{

}
