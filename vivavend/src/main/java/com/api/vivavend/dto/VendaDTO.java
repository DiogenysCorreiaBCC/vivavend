package com.api.vivavend.dto;



import com.api.vivavend.model.Avaliacao;
import com.api.vivavend.model.Produto;

/**
 * DTO (Data Transfer Object) para representar uma Venda.
 * @author Ismael
 */

public class VendaDTO {
	private Produto produto;
	private Avaliacao avaliacao;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}
