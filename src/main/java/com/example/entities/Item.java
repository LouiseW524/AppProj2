package com.example.entities;

import com.example.enums.Category;

public class Item {

	private int id;
	private static int nextId = 0;
	private int quantity;
	private String name;
	private double price;
	private Category category;
	
	public Item(int quantity, String name, double price, Category category) {
		super();
		setNewId();
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	private void setNewId() {
		id = nextId;
		nextId++;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
