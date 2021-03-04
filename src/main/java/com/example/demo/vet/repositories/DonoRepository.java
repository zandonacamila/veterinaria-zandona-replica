package com.example.demo.vet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vet.models.Dono;

@Repository
public interface DonoRepository extends JpaRepository<Dono, Integer> {

}
