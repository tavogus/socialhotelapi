package com.socialhotelapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.socialhotelapi.domain.Cliente;
import com.socialhotelapi.repository.ClientesRepository;
import com.socialhotelapi.services.exceptions.ClienteNaoEncontradoException;


@Service
public class ClientesService {

	@Autowired
	private ClientesRepository clientesRepository;

	public List<Cliente> listar() {
		return clientesRepository.findAll();
	}

	public Cliente buscar(Long id) {
		Cliente cliente = clientesRepository.findOne(id);

		if (cliente == null) {
			throw new ClienteNaoEncontradoException("Cliente nao pode ser encontrado");
		}
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente){
		cliente.setId(null);
		return clientesRepository.save(cliente);
	}
	
	public void deletar(Long id) {
		try {
			clientesRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException("Cliente nao pode ser encontrado");
		}
	}
	
	public void atualizar(Cliente cliente){
		verificarExistencia(cliente);
		clientesRepository.save(cliente);
	}
	
	private void verificarExistencia(Cliente cliente){
		buscar(cliente.getId());
		
	}

}
