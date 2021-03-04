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

		Animal animalDB = animalRepository.findByNomeAnimal(animal.getNomeAnimal()).get();
		if(animalRepository.findByNomeAnimal(animal.getNomeAnimal()).isEmpty()) {
			animalRepository.save(animal);
		} else if (animalDB.getIdadeAnimal() != animal.getIdadeAnimal() ||
				   animalDB.getEspecie() != animal.getEspecie() || 
				   animalDB.getRaca() != animal.getRaca() || 
				   animalDB.getNomeAnimal() != animal.getNomeAnimal()) {
 			animalRepository.save(animal);
		} else {
			throw new Exception();
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
