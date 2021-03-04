package com.example.demo.vet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vet.models.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}
