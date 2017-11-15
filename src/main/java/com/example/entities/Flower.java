package com.example.entities;

import com.example.enums.Category;

public class Flower extends Item{
	
	private String colour;

	public Flower(int id, String name, double price, Category category, String colour) {
		super(id, name, price, category);
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
