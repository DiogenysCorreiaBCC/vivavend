package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.vivavend.model.Endereco;

public interface EnderecoServiceInterface {
    Endereco saveEndereco(Endereco endereco);
    List<Endereco> getAllEndereco();
    Optional<Endereco> findEnderecoById(UUID id);
    void deleteEndereco(Endereco endereco);
}
