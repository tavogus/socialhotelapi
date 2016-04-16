package com.socialhotelapi.services.exceptions;

public class QuartoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = -2229047396453351739L;
	
	public QuartoNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	
	public QuartoNaoEncontradoException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
