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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private Fachada fachada;

    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fachada.saveProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getTodosProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(fachada.getAllProduto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUmProduto(@PathVariable(value = "id") UUID id){
        Optional<Produto> ProdutoOptional = fachada.findProdutoById(id);
        if (!ProdutoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ProdutoOptional.get());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") UUID id){
        Optional<Produto> ProdutoOptional = fachada.findProdutoById(id);
        if (!ProdutoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        
        fachada.deleteProduto(ProdutoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProdutoDTO produtoDTO){
        Optional<Produto> produtoOptional = fachada.findProdutoById(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        produto.setId(produtoOptional.get().getId());
        //Produto.setRegistrationDate(ProdutoOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.saveProduto(produto));
    }
}







