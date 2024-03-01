package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.vivavend.model.Venda;

/**
 * 
 * 
 * @author Ismael
 */

public interface VendaServiceInterface {
    public Venda saveVenda(Venda venda);
    public List<Venda> getAllVenda();
    public Optional<Venda> findVendaById(UUID id);
    public void deleteVenda(Venda venda);
}
