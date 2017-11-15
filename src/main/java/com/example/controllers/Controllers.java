package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Flower;
import com.example.entities.Person;
import com.example.repositories.FlowerRepo;
import com.example.repositories.PersonRepo;

@Controller
public class Controllers {
	@Autowired
	PersonRepo personRepo;
	@Autowired
	FlowerRepo flowerRepo;
	
	final String DISPLAY_ALL_FLOWERS = "displayAllFlowers";
	final String INDEX = "index";
	final String USING_PARAMETER = "usingParameter";
	final String DISPLAY_ALL_PEOPLE = "displayAllPeople";
	final String DISPLAY_PERSON = "displayPerson";
	final String DISPLAY_FLOWER = "displayFlower";
	/**
	 * Calls index.html
	 */
	@GetMapping("/")
	public String doWelcomeWithParams(Model model)
	{
		return INDEX;
	}
	/*
	 * An example of using a path variable.
	 * localhost:8080/usingParameter?name=Cliona will add Cliona to the welcome
	 * localhost:8080/usingParameter uses the default value of To You!
	 */
	@GetMapping("/" + USING_PARAMETER)
	public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To You!")String name, Model model)
	{
		String sentence = "Welcome " + name;
		model.addAttribute("message", sentence);
		return USING_PARAMETER;
	}
	/*
	 * The repository uses the in-built findAll() method of MongoRepository
	 * This returns a list of People
	 * This list is added to the model
	 * The model is sent to the displayAll.html template.
	 */
	@GetMapping("/" + DISPLAY_ALL_PEOPLE)
	public String displayAll(Model model)
	{
		List<Person> p = personRepo.findAll();
		model.addAttribute("people", p);
		return DISPLAY_ALL_PEOPLE;
	}
	/*
	 * This uses a PathVariable to specify the id being searched for.
	 * findOne() is the default method to search for one record using MongoRepository.
	 * It returns one record.
	 * This record is added to the model.
	 * The model is sent to the displayOne.html resolver.
	 */
	@GetMapping("/" + DISPLAY_PERSON + "/{id}")
	public String showMyDetails(@PathVariable int id, Model model)
	{
		Person p = (Person) personRepo.findOne((int) id);
		model.addAttribute("person", p);
		return DISPLAY_PERSON;
	}
	
	@GetMapping("/" + DISPLAY_ALL_FLOWERS)
	public String displayAllFlowers(Model model) {
		List<Flower> flowers = flowerRepo.findAll();
		model.addAttribute("flowers", flowers);
		return DISPLAY_ALL_FLOWERS;
	}
	
	@GetMapping("/" + DISPLAY_FLOWER + "/{id}")
	public String displayFlower(@PathVariable int id, Model model ) {
		Flower flower = (Flower) flowerRepo.findOne((int) id);
		model.addAttribute("flower", flower);
		return DISPLAY_FLOWER;
	}
	
}
