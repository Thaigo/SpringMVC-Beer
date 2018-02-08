package com.freitas.beer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freitas.beer.model.Cerveja;
import com.freitas.beer.model.Origem;
import com.freitas.beer.model.Sabor;
import com.freitas.beer.repository.EstilosRepository;
import com.freitas.beer.service.CadastroCervejaService;

@Controller
public class CervejasController {
	
	@Autowired
	private EstilosRepository estilosRepository;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;

	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilosRepository.findAll());
		mv.addObject("origens", Origem.values());
		
		return mv;
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {

		if (result.hasErrors()) {			
			return novo(cerveja);
		}
		
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja Salva com sucesso");
		/*System.out.println("SKU: " + cerveja.getSku());
		System.out.println("Nome: " + cerveja.getNome());
		System.out.println("Estoque: " + cerveja.getQuantidadeEstoque());
		System.out.println("Sabor: " + cerveja.getSabor());
		System.out.println("Origem: " + cerveja.getOrigem());		
		System.out.println("Estilo: " + cerveja.getEstilo());
		System.out.println("Descricao: " + cerveja.getDescricao());
		System.out.println("Comissao: " + cerveja.getComissao());
		System.out.println("Teor Alcoolico: " + cerveja.getTeorAlcoolico());*/
		
		return new ModelAndView("redirect:/cervejas/novo");
	}	
	

}
