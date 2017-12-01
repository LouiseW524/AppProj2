package com.example.entities;

public class Card {
	
	private String address;
	private String recipientName;
	private Person sender;
	private String message;
	private String customMessage;
	
	public Card(String address, String recipientName, Person sender, String message, String customMessage) {
		super();
		this.address = address;
		this.recipientName = recipientName;
		this.sender = sender;
		this.message = message;
		this.customMessage = customMessage;
	}
	
	@Override
	public String toString() {
		return "Card [address=" + address + ", recipientName=" + recipientName + ", sender=" + sender + ", message="
				+ message + ", customMessage=" + customMessage + "]";
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRecipientName() {
		return recipientName;
	}
	
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	public Person getSender() {
		return sender;
	}
	
	public void setSender(Person sender) {
		this.sender = sender;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCustomMessage() {
		return customMessage;
	}
	
	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
	

}
