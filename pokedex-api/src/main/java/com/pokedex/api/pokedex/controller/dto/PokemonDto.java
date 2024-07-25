package com.pokedex.api.pokedex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.pokedex.api.pokedex.model.Pokemon;

public class PokemonDto {
	private String name;
	private String url;

	public PokemonDto(Pokemon pokemon) {
		this.name = pokemon.getName();
		this.url = pokemon.getUrl();
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public static List<PokemonDto> convert(List<Pokemon> pokemons) {
		return pokemons.stream().map(PokemonDto::new).collect(Collectors.toList());
	}
	
}
