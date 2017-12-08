package com.example.entities;

import com.example.enums.Category;

public class Flower extends Item{
	
	private String colour;
	private int quantity;

	public Flower(int quantity, String name, double price, Category category, String colour) {
		super(name, price, category);
		this.quantity = quantity;
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

}
