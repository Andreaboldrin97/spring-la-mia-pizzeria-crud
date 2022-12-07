package org.generation.italy.pizza.demo.repo;

import java.util.List;

import org.generation.italy.pizza.demo.pojo.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

//indichiamo a quale tabella fa riferimento l'interfaccia 
public interface DrinkRepo extends JpaRepository<Drink, Integer> {

	//metodo custum per la ricerca
	//il nome del metodo ha le parole chiavi per effetuare la chiamata sql 
	public List<Drink> findBynameContainingIgnoreCase(String name);
}
