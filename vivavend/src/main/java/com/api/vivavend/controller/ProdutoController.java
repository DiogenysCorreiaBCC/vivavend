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

import com.api.vivavend.dto.ProdutoDTO;
import com.api.vivavend.fachada.Fachada;
import com.api.vivavend.model.Produto;

import jakarta.validation.Valid;

/**
 * Controlador responsável por lidar com operações relacionadas a produtos.
 * 
 * Todas as operações neste controlador estão mapeadas para o endpoint "/produto".
 * Este controlador permite salvar, exibir, atualizar e deletar produtos.
 * @author Ismael
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private Fachada fachada;

    /**
     * Salva um novo produto com base nos dados fornecidos.
     * 
     * @param produtoDTO O objeto ProdutoDTO contendo os dados do produto a ser criado
     * @return ResponseEntity contendo o status da operação e o produto criado
     */
    @PostMapping
    public ResponseEntity<Object> salvarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fachada.salvarProduto(produto));
    }

    /**
     * Retorna todos os produtos cadastrados no sistema.
     * 
     * @return ResponseEntity contendo o status da operação e a lista de todos os produtos
     */
    @GetMapping
    public ResponseEntity<List<Produto>> exibirTodosProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(fachada.retornarTodosProduto());
    }

    /**
     * Retorna um produto específico com base no ID fornecido.
     * 
     * @param id O ID do produto a ser recuperado
     * @return ResponseEntity contendo o status da operação e o produto encontrado, se existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> exibirUmProduto(@PathVariable(value = "id") UUID id){
        Optional<Produto> ProdutoOptional = fachada.buscarProdutoPorId(id);
        if (!ProdutoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ProdutoOptional.get());
    }
    
    /**
     * Exclui um produto com base no ID fornecido.
     * 
     * @param id O ID do produto a ser excluído
     * @return ResponseEntity contendo o status da operação
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value = "id") UUID id){
        Optional<Produto> ProdutoOptional = fachada.buscarProdutoPorId(id);
        if (!ProdutoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        
        fachada.deletarProduto(ProdutoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso!");
    }

    /**
     * Atualiza os dados de um produto com base no ID fornecido.
     * 
     * @param id O ID do produto a ser atualizado
     * @param produtoDTO O objeto ProdutoDTO contendo os novos dados do produto
     * @return ResponseEntity contendo o status da operação e o produto atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProdutoDTO produtoDTO){
        Optional<Produto> produtoOptional = fachada.buscarProdutoPorId(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        produto.setId(produtoOptional.get().getId());
        //Produto.setRegistrationDate(ProdutoOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.salvarProduto(produto));
    }
}







