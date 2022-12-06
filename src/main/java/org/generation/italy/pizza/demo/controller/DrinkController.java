package org.generation.italy.pizza.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pizza.demo.pojo.Drink;
import org.generation.italy.pizza.demo.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

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
	
	//metodo per creare un record
	@GetMapping("/drink/create")
	public String createDrink(Model model) {
		
		//creiamo un istanza del record da creare 
		Drink drink = new Drink();
		//portiamo il record alla pagina in modo da indicare le collone che lo compongono
		model.addAttribute("drink", drink);
		//a quale view fa riferimento
		return "drinkCRUD/create";
	}
	@PostMapping("/drink/create")
	public String storeDrink(@Valid Drink drink) {
		
		//metodo per salvare un record
		drinkService.save(drink);
		
		//a quale view ritorna
		return "redirect:/drink";
	}
	
	//metodo per modificare un record
	@GetMapping("/drink/edit/{id}")
	public String editDrink(@PathVariable("id") int id, Model model) {
		
		// selezioniamo il record con quell'id
		Optional<Drink> optDrink= drinkService.findDrinkById(id);
		Drink drink = optDrink.get();
		//portiamo il record alla pagina in modo da indicare le collone che lo compongono
		model.addAttribute("drink", drink);
		
		return "drinkCRUD/update";
	}
}
