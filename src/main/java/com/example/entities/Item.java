package com.example.entities;

import com.example.enums.Category;

public class Item {

	private Long id;
	private static Long nextId = 1L;
	private String name;
	private double price;
	private Category category;
	
	public Item(String name, double price, Category category) {
		super();
		setNewId();
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

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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


}
