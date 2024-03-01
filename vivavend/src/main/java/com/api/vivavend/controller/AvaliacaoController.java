package com.api.vivavend.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vivavend.dto.AvaliacaoDTO;
import com.api.vivavend.fachada.Fachada;
import com.api.vivavend.model.Avaliacao;

import jakarta.validation.Valid;

/**
 * Controller responsável por lidar com requisições relacionadas a avaliações.
 * Todas as operações CRUD (Criar, Ler, Atualizar, Deletar) estão implementadas aqui.
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/avaliacao")
public class AvaliacaoController {
	@Autowired
	private Fachada fachada;
	
	
    /**
     * Endpoint para salvar uma nova avaliação.
     * 
     * @param avaliacaoDTO O objeto AvaliacaoDTO contendo os dados da avaliação a ser salva
     * @return ResponseEntity contendo o status da operação e a avaliação salva, se bem sucedida
     */
	@PostMapping
	public ResponseEntity<Object> salvarAvaliacao(@RequestBody @Valid AvaliacaoDTO avaliacaoDTO) {
		var avaliacao = new Avaliacao();
		BeanUtils.copyProperties(avaliacaoDTO, avaliacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(fachada.salvarAvaliacao(avaliacao));
	}
	
	 /**
     * Endpoint para buscar uma avaliação pelo seu ID.
     * 
     * @param id O ID da avaliação a ser buscada
     * @return ResponseEntity contendo o status da operação e a avaliação encontrada, se existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> retornarUmaAvaliacao(@PathVariable(value = "id") UUID id){
    	Optional<Avaliacao> avaliacaoOptional = fachada.buscarAvaliacaoPorId(id);
    	if (!avaliacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoOptional.get());
    }
    
    /**
     * Endpoint para deletar uma avaliação pelo seu ID.
     * 
     * @param id O ID da avaliação a ser deletada
     * @return ResponseEntity contendo o status da operação e uma mensagem de sucesso, se bem sucedida
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAvaliacao(@PathVariable(value = "id") UUID id){
        Optional<Avaliacao> avaliacaoOptional = fachada.buscarAvaliacaoPorId(id);
        if (!avaliacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        fachada.deletarAvaliacao(avaliacaoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Avaliação removida com sucesso!");
    }
    
    /**
     * Endpoint para editar uma avaliação existente.
     * 
     * @param id O ID da avaliação a ser editada
     * @param avaliacaoDTO O objeto AvaliacaoDTO contendo os novos dados da avaliação
     * @return ResponseEntity contendo o status da operação e a avaliação atualizada, se bem sucedida
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> editarAvaliacao(@PathVariable(value = "id") UUID id, @RequestBody @Valid AvaliacaoDTO avaliacaoDTO){
        Optional<Avaliacao> avaliacaoOptional = fachada.buscarAvaliacaoPorId(id);
        if (!avaliacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        var avaliacao = new Avaliacao();
        BeanUtils.copyProperties(avaliacaoDTO, avaliacao);
        avaliacao.setId(avaliacaoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.salvarAvaliacao(avaliacao));
    }
}




























