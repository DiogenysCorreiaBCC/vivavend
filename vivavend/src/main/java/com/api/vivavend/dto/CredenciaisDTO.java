package com.api.vivavend.dto;

/**
 * DTO (Data Transfer Object) para representar credenciais de usuário.
 * @author Ismael
 */

public class CredenciaisDTO {
	private String nomeDeUsuário;
	private String senha;
	
	
	public String getNomeDeUsuário() {
		return nomeDeUsuário;
	}
	public void setNomeDeUsuário(String nomeDeUsuário) {
		this.nomeDeUsuário = nomeDeUsuário;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
