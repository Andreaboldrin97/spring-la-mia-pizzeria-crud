package org.generation.italy.pizza.demo.repo;

import org.generation.italy.pizza.demo.pojo.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

//indichiamo a quale tabella fa riferimento l'interfaccia 
public interface DrinkRepo extends JpaRepository<Drink, Integer> {

}
