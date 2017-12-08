package com.example.entities;

import java.util.ArrayList;

public class EventPackage {
	
	private Long id;
	private static Long nextId = 1L;
	private ArrayList <Item> items = new ArrayList <Item>();
	private Bouquet bouquet;
	private String eventName;
	
	public EventPackage(String eventName, ArrayList<Item> items, Bouquet bouquet) {
		super();
		this.items = items;
		this.bouquet = bouquet;
		this.eventName = eventName;
		setNewId();
	}
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	private void setNewId() {
		id = nextId;
		nextId++;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
