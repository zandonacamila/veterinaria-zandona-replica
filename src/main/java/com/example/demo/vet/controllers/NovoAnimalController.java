package com.example.demo.vet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.vet.models.Animal;
import com.example.demo.vet.models.Especie;
import com.example.demo.vet.models.Raca;
import com.example.demo.vet.services.AnimalService;

@Controller
public class NovoAnimalController {

	@Autowired
	private AnimalService animalService;
	
	@GetMapping("/cadastraAnimal")
	public String paginaCadastraAnimal(@ModelAttribute Animal animal, Model model, @ModelAttribute Especie especie, @ModelAttribute Raca raca) {
		List<Especie> especies = animalService.listaEspecies();
		model.addAttribute("especies", especies);
		return "cadastraAnimal";
	}
	
	@PostMapping("/cadastraNovoAnimal")
	public String fazOCadastro(@ModelAttribute Animal animal, Model model, RedirectAttributes redirAttrs) {
		try {
			animalService.salva(animal);
			
		} catch(Exception e) {
			redirAttrs.addFlashAttribute("errorMessage", e.getLocalizedMessage());
			// criar uma classe de exceção customizada para arrumar aqui
		}
		
		return "redirect:/cadastraAnimal";
	}
}
