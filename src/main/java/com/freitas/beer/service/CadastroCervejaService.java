package com.freitas.beer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freitas.beer.model.Cerveja;
import com.freitas.beer.repository.CervejasRepository;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private CervejasRepository cervejasRepository;
	
	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejasRepository.save(cerveja);
	}
}
