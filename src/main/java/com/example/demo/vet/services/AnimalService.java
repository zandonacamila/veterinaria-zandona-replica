package com.example.demo.vet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.vet.models.Animal;
import com.example.demo.vet.models.Especie;
import com.example.demo.vet.repositories.AnimalRepository;
import com.example.demo.vet.repositories.EspecieRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;	

	@Autowired
	private EspecieRepository especieRepository;

	@Autowired
	private RacaRepository racaRepository;
	
	public void salvaAnimal(Animal animal) {
		animalRepository.save(animal);	
	}

	public void salva(Animal animal, Integer id) throws Exception {

		try {
			validaAnimal(animal);
			preparaAnimal(animal);
			salvaAnimal(animal);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void validaAnimal(Animal animal) {
		
		Animal animalDB;
		
		if(animalRepository.findByNomeAnimal(animal.getNomeAnimal()).isPresent()) {
			animalDB = animalRepository.findByNomeAnimal(animal.getNomeAnimal()).get();
		} else {
			animalDB = null;
		}

		try {
			if(animalDB == null) {
				preparaAnimal(animal);
			} else if (!animalDB.equals(animal)) {
				preparaAnimal(animal);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void preparaAnimal(Animal animal) {
		
		if(racaRepository.findAll().isEmpty()) {
			animal.getRaca().setEspecie(animal.getEspecie());
			animal.setRaca(animal.getRaca());
		} else if(animal.getRaca().equals(racaRepository.findByNome(animal.getRaca().getNome()))){
			
			animal.setRaca(racaRepository.findByNome(animal.getRaca().getNome()));
		
		}
	}
	
	public List<Especie> listaEspecies() {
		return especieRepository.findAll();
	}
}
