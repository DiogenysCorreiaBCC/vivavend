package com.api.vivavend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.vivavend.model.Empresa;

/**
 * 
 * 
 * @author Ismael
 */

public interface EmpresaServiceInterface {
    public Empresa saveEmpresa(Empresa empresa);
    public List<Empresa> getAllEmpresa();
    public Optional<Empresa> findEmpresaById(UUID id);
    public void deleteEmpresa(Empresa empresa);
}
