package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Endereco;
import com.api.vivavend.repository.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService implements EnderecoServiceInterface{
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public Endereco saveEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
    
    @Override
    public List<Endereco> getAllEndereco() {
        return enderecoRepository.findAll();
    }

    @Override
    public Optional<Endereco> findEnderecoById(UUID id) {
        return enderecoRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteEndereco(Endereco endereco) {
        enderecoRepository.delete(endereco);
    }
}
