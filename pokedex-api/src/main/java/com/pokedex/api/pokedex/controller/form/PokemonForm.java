package com.pokedex.api.pokedex.controller.form;

import org.hibernate.validator.constraints.Length;

import com.pokedex.api.pokedex.model.Pokemon;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PokemonForm {

	@NotNull
	@Length(min = 2)
	private String name;
	@NotNull
	private String url;
	
	public PokemonForm() {
	}

	public PokemonForm(Pokemon pokemon) {
		this.name = pokemon.getName();
		this.url = pokemon.getUrl();
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public Pokemon convert(@Valid PokemonForm form) {
		return new Pokemon(form.getName(), form.getUrl());
	}
}
