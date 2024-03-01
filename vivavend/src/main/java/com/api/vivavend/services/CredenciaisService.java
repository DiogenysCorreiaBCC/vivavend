package com.api.vivavend.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Credenciais;
import com.api.vivavend.repository.CredenciaisRepository;

import jakarta.transaction.Transactional;

/**
 * Serviço responsável por operações relacionadas a credenciais.
 * @author Ismael
 */

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
	
    /**
     * Busca as credenciais pelo nome de usuário.
     * 
     * @param nomeDeUsuario O nome de usuário das credenciais a serem buscadas.
     * @return Um Optional contendo as credenciais, se encontradas.
     */
	@Override
    public Optional<Credenciais> findByNomeDeUsuario(String nomeDeUsuario){
    	return credenciaisRepository.findByNomeDeUsuario(nomeDeUsuario);
    }
	
    /**
     * Busca as credenciais pelo ID.
     * 
     * @param id O ID das credenciais a serem buscadas.
     * @return Um Optional contendo as credenciais, se encontradas.
     */
	@Override
    public Optional<Credenciais> findById(UUID id){
		return credenciaisRepository.findById(id);
	}
}
