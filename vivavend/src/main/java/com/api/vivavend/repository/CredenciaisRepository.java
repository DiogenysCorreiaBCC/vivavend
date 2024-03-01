package com.api.vivavend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Credenciais;

/**
 * Interface de repositório para a entidade Credenciais.
 * Esta interface estende JpaRepository fornecendo operações CRUD básicas para a entidade Credenciais.
 * 
 * @author Ismael
 */

@Repository
public interface CredenciaisRepository extends JpaRepository<Credenciais,UUID>{
    Optional<Credenciais> findByNomeDeUsuario(String nomeDeUsuario);
    Optional<Credenciais> findCredenciaisById(UUID id);
}
