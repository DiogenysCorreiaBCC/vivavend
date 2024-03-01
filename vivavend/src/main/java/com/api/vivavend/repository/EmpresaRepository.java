package com.api.vivavend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Empresa;

/**
 * Interface de repositório para a entidade Empresa.
 * Esta interface estende JpaRepository fornecendo operações CRUD básicas para a entidade Empresa.
 * 
 * @author Ismael
 */

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,UUID>{

}
