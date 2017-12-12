package com.example.entities;


public class EventPackageOrder {

	private Long id;
	private static Long nextId = 1L;
	private EventPackage eventPackage;
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

	public EventPackage getEventPackage() {
		return eventPackage;
	}
	public void setEventPackage(EventPackage eventPackage) {
		this.eventPackage = eventPackage;
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
		if (eventPackage != null) {
			for (Flower flower : eventPackage.getBouquet().getFlowers()) {
				price += flower.getPrice() * flower.getQuantity();
			}
			for (Item item : eventPackage.getItems()) {
				price += item.getPrice();
			}
		}
		
		orderPrice = price;
		calculateBalance();
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public EventPackageOrder(EventPackage eventPackage, String buyer) {
		super();
		this.eventPackage = eventPackage;
		this.buyer = buyer;
		updateOrderPrice();
		setNewId();
	}

	public EventPackageOrder() {
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
