package com.api.vivavend.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/**
 * Representa uma Venda no sistema.
 * Esta classe é uma entidade JPA mapeada para a tabela de avaliações no banco de dados.
 * Pode ser estendida por classes específicas de tipos de avaliação.
 * @author Ismael
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Avaliacao avaliacao;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
