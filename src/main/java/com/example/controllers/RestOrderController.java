package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Bouquet;
import com.example.entities.EventPackage;
import com.example.entities.Flower;
import com.example.entities.Order;
import com.example.enums.Category;
import com.example.entities.Item;

import com.example.repositories.ItemRepo;
import com.example.repositories.OrderRepo;

@RestController
@RequestMapping("/rest/orders")
public class RestOrderController {
	
	@Autowired
	OrderRepo orderRepo;
	@Autowired
	ItemRepo itemRepo;
	private final String ID_SUFFIX = "/{id}";
	private final String ID = "id";
	private final String BALANCE = "/balance"; 

	@RequestMapping(method = RequestMethod.GET, value = ID_SUFFIX)
	public Order getOrder(@PathVariable(ID) Long id) {
		Order order = orderRepo.findOne(id.intValue());
		return order;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Order> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addOrder(@RequestBody Order order) {
		orderRepo.save(order);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = BALANCE)
	public List<Double> getAllOrdersBalance() {
		List<Order> orders = orderRepo.findAll();
		List<Double> balances = new ArrayList<Double>();
		for (Order order : orders) {
			balances.add(order.getBalance());
		}
		return balances;
	}
	
	@RequestMapping(value = "/submitPage" , method = RequestMethod. POST)
	public EventPackage bouquetFlowers(@RequestParam("eventName")String eventName, @RequestParam("flower")String[] flowerboxValue, @RequestParam("item")String[] itemboxValue) 
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
		
		if(flowerboxValue.length==2)
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
		
		if(itemboxValue.length==2)
    	{
	      for(String string : itemboxValue){
	    	  for(Item item : noFlowerItemList){
	    	  if(string.equalsIgnoreCase(item.getName()))
	    		  items.add(item);
	    	  }
	      }
    	}
		
		EventPackage orderedPackage = new EventPackage(eventName, items, bouquet) ;
		
		return orderedPackage;
		
	}

}
