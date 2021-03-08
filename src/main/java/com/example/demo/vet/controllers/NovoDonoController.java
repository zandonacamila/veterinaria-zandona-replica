package com.example.demo.vet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.vet.models.Animal;
import com.example.demo.vet.models.Dono;
import com.example.demo.vet.models.Endereco;
import com.example.demo.vet.services.DonoService;

@Controller
public class NovoDonoController {
	
	@Autowired
	private DonoService donoService;

	@GetMapping("/cadastraDono")
	public String paginaCadastraDono(@ModelAttribute Dono dono, Model model, @ModelAttribute Endereco endereco) {
		List<Animal> animaisLista = donoService.listaAnimais();
		model.addAttribute("animaisLista", animaisLista);
		return "cadastraDono";
	}
	
	@PostMapping("/cadastraNovoDono")
	public String fazOCadastro(@ModelAttribute Dono dono, Model model, @ModelAttribute Endereco endereco, @ModelAttribute Animal animal) {
		try {
			donoService.salva(dono);
		} catch(Exception e) {
			e.getMessage();
		}
		
		return "redirect:/cadastraDono";
	}
	
	@PostMapping("/cadastraNovoEndereco")
	public String cadastraEndereco(@ModelAttribute Endereco endereco, Model model) {
		try {
			donoService.salvaEndereco(endereco);
		} catch(Exception e) {
			e.getMessage();
		}
		
		return "redirect:/cadastraDono";
	}
}
