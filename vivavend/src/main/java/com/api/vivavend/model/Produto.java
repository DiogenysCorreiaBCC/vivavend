package com.api.vivavend.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 * Representa um Produto no sistema.
 * Esta classe é uma entidade JPA mapeada para a tabela de avaliações no banco de dados.
 * Pode ser estendida por classes específicas de tipos de avaliação.
 * @author Ismael
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private int idProduto;
	private String nome;
	private double preco;
	private String descricao;
	private int qtdeEstoque;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @OneToOne
	@JoinColumn(name = "credenciais_id", referencedColumnName = "id")
    private List<Avaliacao> avaliacoes;
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
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
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public static long getSeriaversionuid() {
		return serialVersionUID;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}
	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}	
	
	
}
