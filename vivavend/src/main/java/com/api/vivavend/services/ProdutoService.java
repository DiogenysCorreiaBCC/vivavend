package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Produto;
import com.api.vivavend.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService implements ProdutoServiceInterface{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public Produto saveProduto(Produto produto){
        return produtoRepository.save(produto);
    }
    
    @Override
    public List<Produto> getAllProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findProdutoById(UUID id){
        return produtoRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteProduto(Produto Produto) {
        produtoRepository.delete(Produto);
    }
}

























