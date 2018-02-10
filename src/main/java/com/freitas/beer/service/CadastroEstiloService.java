package com.freitas.beer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freitas.beer.model.Estilo;
import com.freitas.beer.repository.EstilosRepository;

@Service
public class CadastroEstiloService {
	
	@Autowired
	EstilosRepository estilosRepository;
	
	@Transactional
	public void salvar(Estilo estilo) {
		estilosRepository.save(estilo);
	}

}
