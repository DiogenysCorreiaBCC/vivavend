package com.api.vivavend.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Credenciais implements Serializable{
	public static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String nomeDeUsuario;
	private String senha;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNomeDeUsuário() {
		return nomeDeUsuario;
	}
	public void setNomeDeUsuário(String nomeDeUsuário) {
		this.nomeDeUsuario = nomeDeUsuário;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
