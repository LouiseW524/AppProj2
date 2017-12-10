package com.example.entities;

import java.util.ArrayList;

public class Order {
	
	private Long id;
	private static Long nextId = 1L;
	private ArrayList<Flower> flowers;
	private double orderPrice;
	private double paid;
	private double balance;
	private String buyer;
	
	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public ArrayList<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(ArrayList<Flower> flowers) {
		this.flowers = flowers;
		updateOrderPrice();
	}
	
	public boolean pay(double paying) {
		if ((paid + paying) <= orderPrice) {
			paid += paying;
			calculateBalance();
		} else {
			return false;
		}
		return true;
	}
	
	public double calculateBalance() {
		balance = orderPrice - paid;
		return balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	private void updateOrderPrice() {
		double price = 0.0;
		for (Flower flower : flowers) {
			price += flower.getPrice() * flower.getQuantity();
		}
		
		orderPrice = price;
		calculateBalance();
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public Order(ArrayList<Flower> flowers, String buyer) {
		super();
		this.flowers = flowers;
		this.buyer = buyer;
		updateOrderPrice();
		setNewId();
	}
	
	public Order() {
		super();
		setNewId();
	}
	
	private void setNewId() { 
		id = nextId;
		nextId++;
	}
	
	public Long getId() {
		return id;
	}

}
