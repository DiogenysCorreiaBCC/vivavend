package com.api.vivavend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vivavend.dto.CredenciaisDTO;
import com.api.vivavend.fachada.Fachada;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
	private Fachada fachada;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody CredenciaisDTO credenciaisDTO){
		String nomeDeUsuario = credenciaisDTO.getNomeDeUsuário();
		String senha = credenciaisDTO.getSenha();
		
		if(fachada.autenticar(nomeDeUsuario, senha)) {
			return ResponseEntity.ok("Login validado para o usuário " + nomeDeUsuario);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso Negado!");
	}
}
