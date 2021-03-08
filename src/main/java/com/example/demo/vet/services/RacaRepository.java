package com.example.demo.vet.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vet.models.Raca;

public interface RacaRepository extends JpaRepository<Raca, Integer> {

	public Raca findByNome(String nome);
}
