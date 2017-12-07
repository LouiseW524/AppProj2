package com.example.entities;

import java.util.ArrayList;

public class EventPackage {
	
	private int id;
	private ArrayList <Item> items = new ArrayList <Item>();
	private Bouquet bouquet;
	
	public EventPackage(int id, ArrayList<Item> items, Bouquet bouquet) {
		super();
		this.items = items;
		this.bouquet = bouquet;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Bouquet getBouquet() {
		return bouquet;
	}

	public void setBouquet(Bouquet bouquet) {
		this.bouquet = bouquet;
	}

	@Override
	public String toString() {
		return "EventPackage [id=" + id + ", items=" + items + ", bouquet=" + bouquet + "]";
	}

	

}
