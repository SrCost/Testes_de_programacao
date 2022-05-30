package com.pokedex.aplication;

import com.pokedex.dao.PokedexDAO;
import com.pokedex.model.Pokemon;

public class Main {

	public static void main(String[] args) {
		PokedexDAO pokedexDAO = new PokedexDAO();
		
		//registrando novo pokemon
		Pokemon pokemon = new Pokemon();
		pokemon.setNum(001);
		pokemon.setName("Bulbasaur");
		pokemon.setImg("http://www.serebii.net/pokemongo/pokemon/001.png");
		pokemon.setType("Grass");
		
		pokedexDAO.save(pokemon);
		
		//atualizar a pokedex
		Pokemon p1 = new Pokemon();
		p1.setNum(002);
		p1.setName("Ivysaur");
		p1.setImg("http://www.serebii.net/pokemongo/pokemon/002.png");
		p1.setType("Poison");
		p1.setId(1);
		
		pokedexDAO.update(p1);
		
		//Deletando pokemon da base pelo Id
		pokedexDAO.deleteById(1);
		
		//visualizacao dos registros do banco de dados -Todos-
		for (Pokemon p : pokedexDAO.getPokemon()) {
			System.out.println("Pokemons: "+p.getName());
		}
		
	}

}
