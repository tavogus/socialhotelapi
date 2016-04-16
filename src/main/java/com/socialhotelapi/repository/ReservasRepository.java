package com.socialhotelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialhotelapi.domain.Reserva;

public interface ReservasRepository extends JpaRepository<Reserva, Long>{

}
