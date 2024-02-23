package com.api.vivavend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Credenciais;

@Repository
public interface CredenciaisRepository extends JpaRepository<Credenciais,UUID>{
    Optional<Credenciais> findByNomeDeUsuario(String nomeDeUsuario);
    Optional<Credenciais> findCredenciaisById(UUID id);
}
