package com.freitas.beer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freitas.beer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST) 
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("--->> SKU Deve ser preenchido");
		}
		
		System.out.println("cadastrado Sku: " + cerveja.getSku() + " Realizado com sucesso");
		System.out.println("cadastrado Nome: " + cerveja.getNome() + " Realizado com sucesso");
		return "cerveja/CadastroCerveja";
	}
	
}
