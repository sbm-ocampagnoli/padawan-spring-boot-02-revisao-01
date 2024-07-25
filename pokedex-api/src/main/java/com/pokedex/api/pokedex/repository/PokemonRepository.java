package com.pokedex.api.pokedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokedex.api.pokedex.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

	List<Pokemon> findAllByName(String name);
	
}
