package org.generation.italy.pizza.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.pizza.demo.pojo.Pizza;
import org.generation.italy.pizza.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

//indichiamo che qesta classe ci servirà da controller
@Controller
public class PizzaController {
	
	//indichiamo la dipendenza da iniettare
	@Autowired
	private PizzaService pizzaService;

	//GET PATH without parameters
	
		//HOME
		//Indichiamo a quale path fa riferimento questo metodo
		@RequestMapping("/")
		//indichiamo il metodo publico che ritornerà una Stringa
							//indichiamo la presenza di un model per fornire attributi alla view ritornata
		public String getHome(Model model) {
			//assegnamo alla variabile text un valore 
			String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
						+ "	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
						+ "	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
			//aggiungiamo il valore della variabile al posto dell'elemento text inserito nell'html
			model.addAttribute("text", text);
			
			//ritorniamo il file assocciato al nome "home"
			return "home";
		}
		
		//INDEX PIZZA
		//Indichiamo a quale path fa riferimento questo metodo
		@GetMapping("/allPizzas")
		public String getPizze(Model model) {
			//assegnamo ad un lista i record del db
			List<Pizza> allPizzas = pizzaService.findAll();
			
			model.addAttribute("allPizzas", allPizzas);
			
			//a quale view fa riferimento
			return "pizzaCRUD/index";
		}
		
		//CREATE PIZZA
		//Indichiamo a quale path fa riferimento questo metodo
		@GetMapping("/pizza/create")
		public String createPizza(Model model) {
			
			Pizza pizza = new Pizza();
			model.addAttribute("pizza", pizza);
			
			//a quale view fa riferimento
			return "pizzaCRUD/create";
		}
		@PostMapping("/pizza/create")
		public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
			
			//metodo per salvare un record
			pizzaService.save(pizza);
			
			//a quale view ritorna
			return "redirect:/";
		}
		
		//CREATE PIZZA
		//Indichiamo a quale path fa riferimento questo metodo
		@GetMapping("/pizza/edit/{id}")
		public String editPizza(@PathVariable("id") int id, Model model) {
			
			// selezioniamo il record con quell'id
			Optional<Pizza> optPizza = pizzaService.findPizzaByID(id);
			Pizza pizza  = optPizza.get();
			model.addAttribute("pizza", pizza);
			
			//a quale view fa riferimento
			return "pizzaCRUD/update";
		}
		@PostMapping("/pizza/store")
		public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
			//metodo per salvare un record
			pizzaService.save(pizza);
			
			//a quale view ritorna
			return "redirect:/";
		}
		
		//DELETE PIZZA 
		//Indichiamo a quale path fa riferimento questo metodo
		@GetMapping("/pizza/delete/{id}")
		public String deletePizza(@PathVariable("id") int id) {
			
			// selezioniamo il record con quell'id
			Optional<Pizza> optPizza = pizzaService.findPizzaByID(id);
			Pizza pizza  = optPizza.get();
			//metodo per eliminare un record
			pizzaService.delete(pizza);
			
			//a quale view ritorna
			return "redirect:/";
		}
}
