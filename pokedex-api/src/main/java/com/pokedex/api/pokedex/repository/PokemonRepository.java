package com.pokedex.api.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokedex.api.pokedex.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
	
}
