package com.api.vivavend.services;

import java.util.Optional;
import java.util.UUID;

import com.api.vivavend.model.Credenciais;

public interface CredenciaisServiceInterface {
	Credenciais saveCredenciais(Credenciais credenciais);
	void deleteCredenciais(Credenciais credenciais);
    Optional<Credenciais> findByNomeDeUsuario(String nomeDeUsuario);
    Optional<Credenciais> findById(UUID id);
}
