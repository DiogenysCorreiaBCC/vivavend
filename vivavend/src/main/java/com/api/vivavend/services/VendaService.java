package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Venda;
import com.api.vivavend.repository.VendaRepository;

import jakarta.transaction.Transactional;

/**
 * Serviço responsável por operações relacionadas a Venda.
 * @author Ismael
 */

@Service
public class VendaService implements VendaServiceInterface{
	@Autowired
    private VendaRepository vendaRepository;
	
	@Override
    @Transactional
    public Venda saveVenda(Venda venda){
        return vendaRepository.save(venda);
    }
    
    @Override
    public List<Venda> getAllVenda() {
        return vendaRepository.findAll();
    }

    @Override
    public Optional<Venda> findVendaById(UUID id){
        return vendaRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteVenda(Venda venda) {
        vendaRepository.delete(venda);
    }
}
