package com.example.entities;

public class Flower extends Item{
	
	private String colour;

	public Flower(int id, String name, double price, String colour) {
		super(id, name, price);
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
