package com.example.demo.vet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vet.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
	public Boolean findByNomeAnimal(String nome); 
	
	public Boolean findByEspecie(Integer idEspecie);
	
	public Boolean findByRaca(String raca); 

	public Boolean findByIdadeAnimal(Integer idade); 
}
