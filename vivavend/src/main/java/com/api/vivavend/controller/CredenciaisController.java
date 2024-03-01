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

/**
 * Controlador responsável por lidar com operações relacionadas às credenciais dos usuários.
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/credenciais")
public class CredenciaisController {
	@Autowired
	private Fachada fachada;
	
    /**
     * Atualiza as credenciais de um usuário com base no ID fornecido.
     * 
     * @param id O ID do usuário cujas credenciais serão atualizadas
     * @param credenciaisDTO O objeto CredenciaisDTO contendo as novas credenciais
     * @return ResponseEntity contendo o status da operação e o objeto atualizado das credenciais
     */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCredenciais(@PathVariable(value = "id") UUID id, @RequestBody @Valid CredenciaisDTO credenciaisDTO){
		Optional<Credenciais> credencialOptional = fachada.buscarCredenciaisPorId(id);
		
		if(!credencialOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		
		var credenciais = new Credenciais();
		BeanUtils.copyProperties(credenciaisDTO, credenciais);
		credenciais.setId(credencialOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(fachada.salvarCredenciais(credenciais));
	}
}
