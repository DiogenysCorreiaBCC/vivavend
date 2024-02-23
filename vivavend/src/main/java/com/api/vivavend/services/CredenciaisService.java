package com.api.vivavend.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Credenciais;
import com.api.vivavend.repository.CredenciaisRepository;

import jakarta.transaction.Transactional;

@Service
public class CredenciaisService implements CredenciaisServiceInterface{
	@Autowired
	private CredenciaisRepository credenciaisRepository;
	
	@Override
	@Transactional
	public Credenciais saveCredenciais(Credenciais credenciais){
        return credenciaisRepository.save(credenciais);
    }
	
	@Override
	@Transactional
    public void deleteCredenciais(Credenciais credenciais) {
		credenciaisRepository.delete(credenciais);
	}
	
	@Override
    public Optional<Credenciais> findByNomeDeUsuario(String nomeDeUsuario){
    	return credenciaisRepository.findByNomeDeUsuario(nomeDeUsuario);
    }
	
	@Override
    public Optional<Credenciais> findById(UUID id){
		return credenciaisRepository.findById(id);
	}
}
