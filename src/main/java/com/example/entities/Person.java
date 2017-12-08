package com.example.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	
	@Id
	private int id;
	private static int nextId = 1;
	
	private String name;
	private int age;
	private String emailAddress;
	
	public Person(String name, int age, String emailAddress) {
		super();
		setNewId();
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
	}
	
	private void setNewId() {
		id = nextId;
		nextId++;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
}
