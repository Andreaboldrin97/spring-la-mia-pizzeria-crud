package org.generation.italy.pizza.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//pojo
@Entity
@Table
public class Drink {

	//variabili d'istanza che creerabnno le colonne
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message = "il nome deve contenere qualcosa")
	@Column(length = 50, unique = true)
	private String name;
	
	@Lob
	private String description;

	@NotNull
	@Min(value=1)
	private Integer price;
	
	//costruttore di default
	public Drink() {}
	
	//costruttore custum
	public Drink(String name, String description, Integer price) {
		//metodi di settaggio 
		setName(name);
		setDescription(description);
		setPrice(price);
	}

	// get & set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
}
