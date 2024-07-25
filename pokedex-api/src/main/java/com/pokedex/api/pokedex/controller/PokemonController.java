package com.pokedex.api.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.api.pokedex.controller.dto.PokemonDto;
import com.pokedex.api.pokedex.model.Pokemon;
import com.pokedex.api.pokedex.service.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	@Autowired
	PokemonService service;

	@GetMapping
	public List<PokemonDto> listar(String name) {

		if (name == null) {
			List<Pokemon> pokemons = service.list();
			return PokemonDto.convert(pokemons);
		}
		
		List<Pokemon> pokemons = service.list(name);
		return PokemonDto.convert(pokemons);
	}
}
