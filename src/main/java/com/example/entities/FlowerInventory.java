package com.example.entities;

import java.util.ArrayList;
import java.util.List;

public class FlowerInventory {
	
	private Long id;
	private static Long nextId = 1L;
	private ArrayList<Flower> flowers;
	
	public void addFlower(Flower flower) {
		flowers.add(flower);
	}
	
	public void removeFlower(Flower flower) {
		int index = 0;
		for (index = 0; index < flowers.size(); index++) {
			if (flowers.get(index) == flower) {
				flowers.remove(index);
				break;
			}
		}		
	}
	
	public ArrayList<Flower> getFlowers() {
		return flowers;
	}
	
	public void setFlowers(ArrayList<Flower> flowers) {
		this.flowers = flowers;
	}
	
	private void setNewId() {
		setId(nextId);
		nextId++;
	}

	public FlowerInventory(ArrayList<Flower> flowers, ArrayList<Integer> quantity) {
		super();
		setNewId();
		this.flowers = flowers;
	}
	
	public FlowerInventory() {
		super();
		setNewId();
		flowers = new ArrayList<Flower>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
