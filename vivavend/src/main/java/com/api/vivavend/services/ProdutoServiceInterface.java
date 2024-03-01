package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.vivavend.model.Produto;

/**
 * 
 * 
 * @author Ismael
 */

public interface ProdutoServiceInterface {
    public Produto saveProduto(Produto produto);
    public List<Produto> getAllProduto();
    public Optional<Produto> findProdutoById(UUID id);
    public void deleteProduto(Produto Produto);
}
