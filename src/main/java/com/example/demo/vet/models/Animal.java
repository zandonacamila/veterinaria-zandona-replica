package com.example.demo.vet.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeAnimal;
	private Integer idadeAnimal;
	
	@OneToOne
	private Especie especie;
	
	private String raca;

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public Integer getIdadeAnimal() {
		return idadeAnimal;
	}

	public void setIdadeAnimal(Integer idadeAnimal) {
		this.idadeAnimal = idadeAnimal;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((idadeAnimal == null) ? 0 : idadeAnimal.hashCode());
		result = prime * result + ((nomeAnimal == null) ? 0 : nomeAnimal.hashCode());
		result = prime * result + ((raca == null) ? 0 : raca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.getId().equals(other.especie.getId()))
			return false;
		if (idadeAnimal == null) {
			if (other.idadeAnimal != null)
				return false;
		} else if (!idadeAnimal.equals(other.idadeAnimal))
			return false;
		if (nomeAnimal == null) {
			if (other.nomeAnimal != null)
				return false;
		} else if (!nomeAnimal.equals(other.nomeAnimal))
			return false;
		if (raca == null) {
			if (other.raca != null)
				return false;
		} else if (!raca.equals(other.raca))
			return false;
		return true;
	}
}
