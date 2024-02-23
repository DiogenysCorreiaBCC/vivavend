package com.api.vivavend.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vivavend.dto.CredenciaisDTO;
import com.api.vivavend.fachada.Fachada;
import com.api.vivavend.model.Credenciais;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/credenciais")
public class CredenciaisController {
	@Autowired
	private Fachada fachada;
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCredenciais(@PathVariable(value = "id") UUID id, @RequestBody @Valid CredenciaisDTO credenciaisDTO){
		Optional<Credenciais> credencialOptional = fachada.findCredenciaisById(id);
		
		if(!credencialOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		
		var credenciais = new Credenciais();
		BeanUtils.copyProperties(credenciaisDTO, credenciais);
		credenciais.setId(credencialOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(fachada.saveCredenciais(credenciais));
	}
}
