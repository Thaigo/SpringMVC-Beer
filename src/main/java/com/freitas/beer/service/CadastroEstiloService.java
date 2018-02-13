package com.freitas.beer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freitas.beer.exception.NomeEstiloJaCadastradoException;
import com.freitas.beer.model.Estilo;
import com.freitas.beer.repository.EstilosRepository;

@Service
public class CadastroEstiloService {
	
	@Autowired
	EstilosRepository estilosRepository;
	
	@Transactional
	public void salvar(Estilo estilo) {
		Optional<Estilo> estiloOptional = estilosRepository.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado");
		}
		
		estilosRepository.save(estilo);
	}

}
