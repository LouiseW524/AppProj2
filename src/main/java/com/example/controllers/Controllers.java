package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.entities.Bouquet;
import com.example.entities.EventPackage;
import com.example.entities.EventPackageOrder;
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
	final String SUBMIT_PAGE = "/submitPage";
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
	
	@RequestMapping(value = "/submitPage" , method = RequestMethod. POST)
	public String bouquetFlowers(@RequestParam("eventName")String eventName, @RequestParam("flower")String[] flowerboxValue, @RequestParam("item")String[] itemboxValue) 
	{
		List<Item> allItems = itemRepo.findAll();
		List<Flower> allFlowers = new ArrayList<Flower>();
		List<Item> noFlowerItemList = new ArrayList<Item>();
	    ArrayList<Item> items = new ArrayList<Item>();

		Bouquet bouquet = null;
		
		for(Item item : allItems){
			if (item.getCategory() == Category.FLOWER) {
				allFlowers.add((Flower) item);
			}
			else{
				noFlowerItemList.add(item);
			}
		}
		
		if(flowerboxValue.length>0)
        	{
		      ArrayList<Flower> flowers = new ArrayList<Flower>();
		      for(String string : flowerboxValue){
		    	  for(Flower flower : allFlowers){
		    	  if(string.equalsIgnoreCase(flower.getName()))
		    		  flowers.add(flower);
		    	  }
		      }
          	   bouquet = new Bouquet(flowers);
        	}
		
		if(itemboxValue.length>0)
    	{
	      for(String string : itemboxValue){
	    	  for(Item item : noFlowerItemList){
	    	  if(string.equalsIgnoreCase(item.getName()))
	    		  items.add(item);
	    	  }
	      }
    	}
//		EventPackageOrder orderOfPackage = null;
//
//		if(bouquet != null){
//			EventPackage orderedPackage = new EventPackage(eventName, items, bouquet) ;
//			orderOfPackage = new EventPackageOrder(orderedPackage, "Website User");
//			
//			String url = "http://localhost:8080/rest/eventPackages/orders";
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			RestTemplate restTemplate = new RestTemplate();
//			HttpEntity<EventPackageOrder> entity = new HttpEntity<EventPackageOrder>(orderOfPackage, headers);
//			restTemplate.postForObject(url, entity, EventPackageOrder.class);
//		}
		return SUBMIT_PAGE;
		
	}
	
	@RequestMapping(value = "/submitPage" , method = RequestMethod.GET)
	public String bouquetFlowersV2() 
	{
		return SUBMIT_PAGE;
		
	}
}
