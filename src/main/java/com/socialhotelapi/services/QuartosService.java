package com.socialhotelapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import com.socialhotelapi.domain.Quarto;
import com.socialhotelapi.repository.QuartosRepository;
import com.socialhotelapi.services.exceptions.QuartoNaoEncontradoException;

@Service
public class QuartosService {

	@Autowired
	private QuartosRepository quartosRepository;

	public List<Quarto> listar() {
		return quartosRepository.findAll();
	}

	public Quarto buscar(Long id) {
		Quarto quarto = quartosRepository.findOne(id);
		
		if(quarto == null){
			throw new QuartoNaoEncontradoException("Quarto nao pode ser encontrado");
		}
		
		return quarto;
	}
	
	public Quarto salvar(Quarto quarto){
		quarto.setId(null);
		return quartosRepository.save(quarto);
	}
	
	public void deletar(Long id) {
		try {
			quartosRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new QuartoNaoEncontradoException("Quarto nao pode ser encontrado");
		}
	}
	
	public void atualizar(Quarto quarto){
		verificarExistencia(quarto);
		quartosRepository.save(quarto);
	}
	
	private void verificarExistencia(Quarto quarto){
		buscar(quarto.getId());
		
	}

}
