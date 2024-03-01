package com.api.vivavend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Credenciais;

/**
 * Serviço responsável pela autenticação de usuários.
 * Verifica se as credenciais fornecidas são válidas.
 * 
 * @author Ismael
 */

@Service
public class AutenticacaoService {
	@Autowired
	private CredenciaisService credenciaisService;
	
    /**
     * Autentica um usuário com base no nome de usuário e senha fornecidos.
     * 
     * @param nomeDeUsuario O nome de usuário fornecido.
     * @param senha A senha fornecida.
     * @return true se as credenciais forem válidas, false caso contrário.
     */
	public boolean autenticar(String nomeDeUsuario, String senha) {
        Optional<Credenciais> credenciaisOpt = credenciaisService.findByNomeDeUsuario(nomeDeUsuario);
        
        if(credenciaisOpt.isPresent()) {
        	Credenciais credenciais = credenciaisOpt.get();
        	
        	return senha.equals(credenciais.getSenha());
        }
        
        return false;
	}
}
