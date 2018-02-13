package com.freitas.beer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freitas.beer.exception.NomeEstiloJaCadastradoException;
import com.freitas.beer.model.Estilo;
import com.freitas.beer.repository.EstilosRepository;
import com.freitas.beer.service.CadastroEstiloService;

@Controller("/estilos")
@RequestMapping
public class EstilosController {
	
	@Autowired
	EstilosRepository estilosRepository;
	
	@Autowired
	CadastroEstiloService cadastroEstiloService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Estilo estilo) {
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes) {

		if (result.hasErrors()) {			
			return novo(estilo);
		}
		
		
		try {
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("mensagem", "Estilo Salvo com sucesso");
		
		
		return new ModelAndView("redirect:/estilos/novo");
	}	
	
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?>  salvar(@RequestBody Estilo estilo) {
		System.out.println(">>>> Estilo" + estilo.getNome());
		
		return ResponseEntity.badRequest().body("Erro Salvando estilo");
	}

}
