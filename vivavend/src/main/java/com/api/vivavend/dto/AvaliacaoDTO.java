package com.api.vivavend.dto;

/**
 * DTO (Data Transfer Object) para representar uma avaliação.
 * @author Ismael
 */

public class AvaliacaoDTO {
	private String comentario;
	private String nota;
	
	
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
}
