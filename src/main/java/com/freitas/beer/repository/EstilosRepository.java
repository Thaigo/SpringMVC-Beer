package com.freitas.beer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freitas.beer.model.Estilo;

@Repository
public interface EstilosRepository extends JpaRepository<Estilo, Long> {
	
	public Optional<Estilo> findByNomeIgnoreCase(String nome);

}
