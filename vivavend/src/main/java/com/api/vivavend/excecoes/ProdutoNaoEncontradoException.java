package com.api.vivavend.excecoes;


/**
 * 
 * 
 * @author Ismael
 */

public class ProdutoNaoEncontradoException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException() {
		super();
	}
	
	public ProdutoNaoEncontradoException(String message) {
		super(message);
	}
}
