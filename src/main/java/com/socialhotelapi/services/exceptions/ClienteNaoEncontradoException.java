package com.socialhotelapi.services.exceptions;

public class ClienteNaoEncontradoException  extends RuntimeException{

	private static final long serialVersionUID = 7573190311895191699L;
	
	public ClienteNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	public ClienteNaoEncontradoException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
