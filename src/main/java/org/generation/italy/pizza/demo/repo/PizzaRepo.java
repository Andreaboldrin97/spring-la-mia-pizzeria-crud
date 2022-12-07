package org.generation.italy.pizza.demo.repo;

import java.util.List;

import org.generation.italy.pizza.demo.pojo.Drink;
import org.generation.italy.pizza.demo.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;


//indichiamo a quale tabella fa riferimento l'interfaccia 
public interface PizzaRepo extends JpaRepository<Pizza, Integer>{
	
	//metodo custum per la ricerca
		//il nome del metodo ha le parole chiavi per effetuare la chiamata sql 
		public List<Pizza> findBynameContainingIgnoreCase(String name);
}
