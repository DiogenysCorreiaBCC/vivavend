package com.api.vivavend.controller;

import java.util.List;
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

import com.api.vivavend.dto.VendaDTO;
import com.api.vivavend.fachada.Fachada;
import com.api.vivavend.model.Venda;

import jakarta.validation.Valid;

/**
 * Controlador responsável por lidar com operações relacionadas a vendas.
 * 
 * Todas as operações neste controlador estão mapeadas para o endpoint "/venda".
 * Este controlador permite salvar, exibir, atualizar e deletar vendas.
 * @author Ismael
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produto")
public class VendaController {
    @Autowired
    private Fachada fachada;
    
    /**
     * Salva uma nova venda com base nos dados fornecidos.
     * 
     * @param vendaDTO O objeto VendaDTO contendo os dados da venda a ser criada
     * @return ResponseEntity contendo o status da operação e a venda criada
     */
    @PostMapping
    public ResponseEntity<Object> salvarVenda(@RequestBody @Valid VendaDTO vendaDTO) {
        var venda = new Venda();
        BeanUtils.copyProperties(vendaDTO, venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(fachada.salvarVenda(venda));
    }
    
    /**
     * Retorna todas as vendas cadastradas no sistema.
     * 
     * @return ResponseEntity contendo o status da operação e a lista de todas as vendas
     */
    @GetMapping
    public ResponseEntity<List<Venda>> exibirTodosAsVendas(){
        return ResponseEntity.status(HttpStatus.OK).body(fachada.retornarTodasAsVendas());
    }
    
    /**
     * Retorna uma venda específica com base no ID fornecido.
     * 
     * @param id O ID da venda a ser recuperada
     * @return ResponseEntity contendo o status da operação e a venda encontrada, se existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> exibirUmaVenda(@PathVariable(value = "id") UUID id){
        Optional<Venda> VendaOptional = fachada.buscarVendaPorId(id);
        if (!VendaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        return ResponseEntity.status(HttpStatus.OK).body(VendaOptional.get());
    }
    
    /**
     * Exclui uma venda com base no ID fornecido.
     * 
     * @param id O ID da venda a ser excluída
     * @return ResponseEntity contendo o status da operação
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarVenda(@PathVariable(value = "id") UUID id){
        Optional<Venda> vendaOptional = fachada.buscarVendaPorId(id);
        if (!vendaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        
        fachada.deletarVenda(vendaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso!");
    }
    
    /**
     * Atualiza os dados de uma venda com base no ID fornecido.
     * 
     * @param id O ID da venda a ser atualizada
     * @param vendaDTO O objeto VendaDTO contendo os novos dados da venda
     * @return ResponseEntity contendo o status da operação e a venda atualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarVenda(@PathVariable(value = "id") UUID id, @RequestBody @Valid VendaDTO vendaDTO){
        Optional<Venda> vendaOptional = fachada.buscarVendaPorId(id);
        if (!vendaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        
        var venda = new Venda();
        BeanUtils.copyProperties(vendaDTO, venda);
        venda.setId(vendaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.salvarVenda(venda));
    }
}
