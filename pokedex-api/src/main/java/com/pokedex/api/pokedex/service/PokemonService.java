package com.pokedex.api.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.api.pokedex.model.Pokemon;
import com.pokedex.api.pokedex.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	PokemonRepository repository;

	public List<Pokemon> list() {
		return this.repository.findAll();
	}

	public List<Pokemon> list(String name) {
		return this.repository.findAllByName(name);
	}

	public Pokemon add(Pokemon pokemon) {
		return this.repository.save(pokemon);
	}
	
}
