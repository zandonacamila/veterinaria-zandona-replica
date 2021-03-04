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
	
	public void salva(Animal animal) throws Exception {
		if(animalRepository.findByNomeAnimal(animal.getNomeAnimal())) {
			animalRepository.save(animal);
		} else if(animalRepository.findByIdadeAnimal(animal.getIdadeAnimal())) {
			animalRepository.save(animal);
		} else if(animalRepository.findByEspecie(animal.getEspecie().getId())) {
			animalRepository.save(animal);
		} else if(animalRepository.findByRaca(animal.getRaca())) {
			animalRepository.save(animal);
		} else {
			throw new Exception("Animal já cadastrado");
		}
		
	}
	
	public List<Especie> listaEspecies() {
		return especieRepository.findAll();
	}

//	public void validaRaca(Animal animal) {
//		if(animalRepository.findByRaca(animal) == null) {
//			animal.setRaca(animal.getRaca());
//			animal.getEspecie().addRaca(animal.getRaca());
//		} else {
//			animal.setRaca(animalRepository.findByRaca(animal));
//		}
//	}
	
}
