package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.EventPackage;
import com.example.entities.Flower;
import com.example.entities.Item;
import com.example.entities.Person;
import com.example.enums.Category;
import com.example.repositories.EventPackageRepo;
import com.example.repositories.ItemRepo;
import com.example.repositories.PersonRepo;

@Controller
public class Controllers {
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	EventPackageRepo packageRepo;
	@Autowired
	ItemRepo itemRepo;
	
	final String BACKEND = "/backend";
	
	final String DISPLAY_ALL_FLOWERS = "/displayAllFlowers";
	final String INDEX = "/index";
	final String USING_PARAMETER = "/usingParameter";
	final String DISPLAY_ALL_PEOPLE = "/displayAllPeople";
	final String DISPLAY_PERSON = "/displayPerson";
	final String DISPLAY_FLOWER = "/displayFlower";
	final String CHOOSE_FLOWER = "/chooseFlowerById";
	final String CHOOSE_PACKAGE = "/choosePackage";
	final String CUSTOM_PACKAGE = "/customPackage";
	/**
	 * Calls index.html
	 */
	@GetMapping("/")
	public String doWelcomeWithParams(Model model)
	{
		return INDEX;
	}
	
	@GetMapping(USING_PARAMETER)
	public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To You!")String name, Model model)
	{
		String sentence = "Welcome " + name;
		model.addAttribute("message", sentence);
		return USING_PARAMETER;
	}

	@GetMapping(DISPLAY_ALL_PEOPLE)
	public String displayAll(Model model)
	{
		List<Person> p = personRepo.findAll();
		model.addAttribute("people", p);
		return DISPLAY_ALL_PEOPLE;
	}
	
	@GetMapping(DISPLAY_PERSON + "/{id}")
	public String showMyDetails(@PathVariable int id, Model model)
	{
		Person p = (Person) personRepo.findOne((int) id);
		model.addAttribute("person", p);
		return DISPLAY_PERSON;
	}
	
	@GetMapping(DISPLAY_ALL_FLOWERS)
	public String displayAllFlowers(Model model) {
		List<Item> flowers = itemRepo.findAll();
		model.addAttribute("flowers", flowers);
		return DISPLAY_ALL_FLOWERS;
	}
	
	@GetMapping(DISPLAY_FLOWER)
	public String displayFlower(@RequestParam(value="id", defaultValue="0")int id, Model model ) {
		Flower flower = (Flower) itemRepo.findOne((int) id);
		model.addAttribute("flower", flower);
		return DISPLAY_FLOWER;
	}
	
	@GetMapping(CHOOSE_FLOWER)
	public String chooseFlowerById() {
		return CHOOSE_FLOWER;
	}
	
	@GetMapping(CHOOSE_PACKAGE) 
	public String choosePackage(Model model){
		List<EventPackage> packages = packageRepo.findAll();
		model.addAttribute("packages", packages);
		return CHOOSE_PACKAGE;
	}
	
	@GetMapping(CUSTOM_PACKAGE) 
	public String customPackage(Model model){
		
		List<Item> items = itemRepo.findAll();
		List<Item> misc = new ArrayList<Item>();
		List<Item> flowers = new ArrayList<Item>();
		for (Item item : items) {
			if (item.getCategory() == Category.FLOWER) {
				flowers.add(item);
			}
			else
			{ misc.add(item); }
		} 
		
		model.addAttribute("items", flowers);
		model.addAttribute("misc", misc);

		return CUSTOM_PACKAGE;
	}
	
}
