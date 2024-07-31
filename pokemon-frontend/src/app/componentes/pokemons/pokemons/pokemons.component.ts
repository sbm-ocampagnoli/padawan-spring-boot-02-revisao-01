import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../pokemon.service';
import { Pokemon } from '../pokemon';

@Component({
  selector: 'app-pokemons',
  templateUrl: './pokemons.component.html',
  styleUrls: ['./pokemons.component.css']
})
export class PokemonsComponent implements OnInit {

  pokemons: Pokemon[] = [];

  constructor(private service: PokemonService) { }

  ngOnInit(): void {

    this.service.listar().subscribe((pokemons) => {
      console.log(pokemons);
      this.pokemons = pokemons;
    }, (error) => {
      console.error('Erro ao listar pokemons:', error);
    });
  }
}
