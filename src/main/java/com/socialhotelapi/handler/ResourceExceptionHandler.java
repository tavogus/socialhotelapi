package com.socialhotelapi.handler;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.socialhotelapi.domain.DetalhesErro;
import com.socialhotelapi.services.exceptions.ClienteNaoEncontradoException;
import com.socialhotelapi.services.exceptions.QuartoNaoEncontradoException;
import com.socialhotelapi.services.exceptions.ReservaNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(QuartoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleQuartoNaoEncontradoException(QuartoNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Quarto nao pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.socialhotelapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClienteNaoEncontradoException(ClienteNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Cliente nao pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.socialhotelapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(ReservaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleReservaNaoEncontradaException(ReservaNaoEncontradaException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("A Reserva nao pode ser encontrada");
		erro.setMensagemDesenvolvedor("http://erros.socialhotelapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}

}
