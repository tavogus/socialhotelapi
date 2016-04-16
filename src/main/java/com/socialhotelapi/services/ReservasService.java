package com.socialhotelapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialhotelapi.domain.Reserva;
import com.socialhotelapi.repository.ReservasRepository;
import com.socialhotelapi.services.exceptions.ReservaNaoEncontradaException;

@Service
public class ReservasService {
	
	@Autowired
	private ReservasRepository reservasRepository;
	
	public List<Reserva> listar(){
		return reservasRepository.findAll();
	}
	
	public Reserva buscar(Long id){
		Reserva reserva = reservasRepository.findOne(id);
		
		if(reserva == null){
			throw new ReservaNaoEncontradaException("Reserva não pode ser encontrada");
		}
		return reserva;
	}
	
	public Reserva salvar(Reserva reserva){
		reserva.setId(null);
		return reservasRepository.save(reserva);
	}

}
