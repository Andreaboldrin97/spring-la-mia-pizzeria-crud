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


@Entity
@Table
public class Pizza {

	//Indichiamo le colonne presenti nella tabella ( variabili d'istanza )
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message = "il titolo deve contenere qualcosa")
	@Column(length = 50)
	private String name;
	
	@NotNull
	@NotEmpty(message = "la descrizione deve contenere qualcosa")
	@Column
	@Lob
	private String description;
	
	@NotNull(message="il prezzo non può essere nullo")
	@Column
	@Min(value=0)
	private int price;
	
	// indichiamo il costruttore di default
	public Pizza() {};
	
	//creiamo il costruttore 
	public Pizza(String name, String description, int price) {

		setName(name);
		setDescription(description);
		setPrice(price);
	}

	//get & set
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

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	};
	
	//toString
	@Override
	public String toString() {

		return "Pizza : " + getId() + "-" + getName() + "-" + getDescription() + "-" + getPrice();
	}
	
}
