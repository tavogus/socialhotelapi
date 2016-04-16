package com.socialhotelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialhotelapi.domain.Cliente;

public interface ClientesRepository  extends JpaRepository<Cliente, Long>{

}
