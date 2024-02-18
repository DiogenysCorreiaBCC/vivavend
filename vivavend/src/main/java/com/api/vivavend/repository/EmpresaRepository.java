package com.api.vivavend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vivavend.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,UUID>{

}
