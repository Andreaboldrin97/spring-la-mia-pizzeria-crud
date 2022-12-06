package org.generation.italy.pizza.demo.controller;

import java.util.List;

import org.generation.italy.pizza.demo.pojo.Drink;
import org.generation.italy.pizza.demo.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//indichiamo che questa classe ci servirà da controller dei drink
@Controller
public class DrinkController {
	
	//indichiamo la dipendenza da iniettare
	@Autowired
	private DrinkService drinkService;
	
	//metodo per ritornare l'index dei drink
	@GetMapping("/drink")
	public String getDrink(Model model) {
		
		//assegnamo ad un lista i record del db
		List<Drink> drinks = drinkService.findAll();
		
		model.addAttribute("drinks", drinks);
		
		return "drinkCRUD/index";
	}
}
