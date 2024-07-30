package com.pokedex.api.pokedex.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pokedex.api.pokedex.controller.dto.PokemonDto;
import com.pokedex.api.pokedex.controller.form.PokemonForm;
import com.pokedex.api.pokedex.model.Pokemon;
import com.pokedex.api.pokedex.service.PokemonService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	@Autowired
	PokemonService service;

	@GetMapping
	public List<PokemonDto> list(String name) {

		if (name == null) {
			List<Pokemon> pokemons = service.list();
			return PokemonDto.convert(pokemons);
		}

		List<Pokemon> pokemons = service.list(name);
		return PokemonDto.convert(pokemons);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PokemonDto> add(@RequestBody @Valid PokemonForm form, UriComponentsBuilder uriBuilder) {

		Pokemon pokemon = form.convert(form);
		service.add(pokemon);

		URI uri = uriBuilder.path("/pokemons/{id}").buildAndExpand(pokemon.getId()).toUri();

		return ResponseEntity.created(uri).body(new PokemonDto(pokemon));

	}
}
