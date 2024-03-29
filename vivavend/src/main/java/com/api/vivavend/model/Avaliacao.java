package com.api.vivavend.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/**
 * Representa uma avaliação no sistema.
 * Esta classe é uma entidade JPA mapeada para a tabela de avaliações no banco de dados.
 * Pode ser estendida por classes específicas de tipos de avaliação.
 * @author Ismael
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Avaliacao implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private static final long serialVersionUID = 1L;
	private String comentario;
	private String nota;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
