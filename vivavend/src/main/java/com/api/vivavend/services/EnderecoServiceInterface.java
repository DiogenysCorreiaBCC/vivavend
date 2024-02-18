package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.vivavend.model.Endereco;

public interface EnderecoServiceInterface {
    public Endereco saveEndereco(Endereco endereco);
    public List<Endereco> getAllEndereco();
    public Optional<Endereco> findEnderecoById(UUID id);
    public void deleteEndereco(Endereco endereco);
}
