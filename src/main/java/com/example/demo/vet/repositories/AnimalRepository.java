package com.example.demo.vet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vet.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
	public Optional<Animal> findByNomeAnimal(String nome); 
	
}
