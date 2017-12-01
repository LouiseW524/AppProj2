package com.example.entities;

import java.util.ArrayList;

public class Bouquet {
	
	private ArrayList<Flower> flowers;
	private Card card;
	public Bouquet(ArrayList<Flower> flowers, Card card) {
		super();
		this.flowers = flowers;
		this.card = card;
	}
	
	@Override
	public String toString() {
		return "Bouquet [flowers=" + flowers + ", card=" + card + "]";
	}
	
	public ArrayList<Flower> getFlowers() {
		return flowers;
	}
	
	public void setFlowers(ArrayList<Flower> flowers) {
		this.flowers = flowers;
	}
	
	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
}
