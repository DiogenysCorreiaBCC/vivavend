package com.api.vivavend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Credenciais;

@Service
public class AutenticacaoService {
	@Autowired
	private CredenciaisService credenciaisService;
	
	public boolean autenticar(String nomeDeUsuario, String senha) {
        Optional<Credenciais> credenciaisOpt = credenciaisService.findByNomeDeUsuario(nomeDeUsuario);
        
        if(credenciaisOpt.isPresent()) {
        	Credenciais credenciais = credenciaisOpt.get();
        	
        	return senha.equals(credenciais.getSenha());
        }
        
        return false;
	}
}
