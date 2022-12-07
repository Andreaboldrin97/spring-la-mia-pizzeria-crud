package org.generation.italy.pizza.demo;

import java.util.List;

import org.generation.italy.pizza.demo.pojo.Drink;
import org.generation.italy.pizza.demo.pojo.Pizza;
import org.generation.italy.pizza.demo.service.DrinkService;
import org.generation.italy.pizza.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication							//IMPLEMENTIAMO
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	//DIPENDENSE
	@Autowired
	private PizzaService pizzaServ;
	
	@Autowired
	private DrinkService drinkServ;
	
	//DATI FAKER
	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("pizza1", "my p1 desc\"", 1000);
		Pizza p2 = new Pizza("pizza2", "my p2 desc", 2200);
		Pizza p3 = new Pizza("pizza3", "my p3 desc", 400);
		Pizza p4 = new Pizza("pizza4", "my p4 desc\"", 1200);
	
		pizzaServ.save(p1);
		pizzaServ.save(p2);
		pizzaServ.save(p3);
		pizzaServ.save(p4);
		
//		List<Pizza> pizzas = pizzaServ.findAll();
//		System.out.println(pizzas);
		
		Drink d1 = new Drink("drink 1", "desc drink 1", 10000);
		Drink d2 = new Drink("drink 2", "desc drink 2", 12000);
		Drink d3 = new Drink("drink 3", "desc drink 3", 1000);
		Drink d4 = new Drink("drink 4", "desc drink 4", 20000);
		
		drinkServ.save(d1);
		drinkServ.save(d2);
		drinkServ.save(d3);
		drinkServ.save(d4);
		
	}
}
