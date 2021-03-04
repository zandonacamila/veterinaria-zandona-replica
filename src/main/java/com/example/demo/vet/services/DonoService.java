package com.example.demo.vet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.vet.models.Animal;
import com.example.demo.vet.models.Dono;
import com.example.demo.vet.models.Endereco;
import com.example.demo.vet.repositories.AnimalRepository;
import com.example.demo.vet.repositories.DonoRepository;
import com.example.demo.vet.repositories.EnderecoRepository;
import com.example.demo.vet.repositories.EspecieRepository;

@Service
public class DonoService {

	@Autowired
	private DonoRepository donoRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void salva(Dono dono) {
		donoRepository.save(dono);
	}
	
	public List<Animal> listaAnimais() {
		return animalRepository.findAll();
	}

	public void salvaEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
		
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
