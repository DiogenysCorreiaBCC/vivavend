package com.api.vivavend.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;

/**
 * Representa um Endereço no sistema.
 * Esta classe é uma entidade JPA mapeada para a tabela de avaliações no banco de dados.
 * Pode ser estendida por classes específicas de tipos de avaliação.
 * @author Ismael
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Endereco implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private static final long serialVersionUID = 1L;
	private String logradouro;
	private String bairro;
	private String numero;
	@OneToOne(mappedBy = "endereco")
	private Empresa empresa;
	
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
