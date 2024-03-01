package com.api.vivavend.dto;

import com.api.vivavend.model.Empresa;

/**
 * DTO (Data Transfer Object) para representar um Endereco.
 * @author Ismael
 */

public class EnderecoDTO {
	private String logradouro;
	private String bairro;
	private String numero;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
