package com.example.entities;

import java.util.ArrayList;

public class Bouquet {
	
	private ArrayList<Flower> flowers;
	public Bouquet(ArrayList<Flower> flowers) {
		super();
		this.flowers = flowers;
		
	}
	


	@Override
	public String toString() {
		return "Bouquet [flowers=" + flowers +" ]";
	}
	
	public ArrayList<Flower> getFlowers() {
		return flowers;
	}
	
	public void setFlowers(ArrayList<Flower> flowers) {
		this.flowers = flowers;
	}
	
	
}
