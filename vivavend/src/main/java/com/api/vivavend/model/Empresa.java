package com.api.vivavend.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


/**
 * Representa uma Empresa no sistema.
 * Esta classe é uma entidade JPA mapeada para a tabela de avaliações no banco de dados.
 * Pode ser estendida por classes específicas de tipos de avaliação.
 * @author Ismael
 */

@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private int idEmpresa;
	private String nome;
	private String email;
	@OneToOne
	@JoinColumn(name = "credenciais_id", referencedColumnName = "id")
	private Credenciais credenciais;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Produto> produtos;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public static long getSeriaversionuid() {
		return serialVersionUID;
	}
	
	public List<Produto> getProduto() {
		return produtos;
	}
	public void setProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Credenciais getCredenciais() {
		return credenciais;
	}
	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
}
