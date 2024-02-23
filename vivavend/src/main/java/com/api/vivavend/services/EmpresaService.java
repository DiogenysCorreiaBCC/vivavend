package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Empresa;
import com.api.vivavend.repository.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService implements EmpresaServiceInterface{
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public Empresa saveEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }
    
    @Override
    public List<Empresa> getAllEmpresa() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findEmpresaById(UUID id) {
        return empresaRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteEmpresa(Empresa empresa) {
        empresaRepository.delete(empresa);
    }
}
