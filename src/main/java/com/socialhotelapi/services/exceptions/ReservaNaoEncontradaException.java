package com.socialhotelapi.services.exceptions;

public class ReservaNaoEncontradaException  extends RuntimeException{

	private static final long serialVersionUID = 7573190311895191699L;
	
	public ReservaNaoEncontradaException(String mensagem){
		super(mensagem);
	}
	public ReservaNaoEncontradaException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}

}
