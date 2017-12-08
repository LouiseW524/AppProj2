package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Flower;
import com.example.entities.Item;

import com.example.repositories.ItemRepo;
import com.example.repositories.FlowerInventoryRepo;
import com.example.repositories.ItemRepo;
import com.example.repositories.OrderRepo;
import com.example.rest.entities.FlowerInventory;
import com.example.rest.entities.Order;


@RestController
public class RestApiController {
	
	@Autowired

	ItemRepo itemRepo;
	@Autowired
	FlowerInventoryRepo flowerInventoryRepo;
	@Autowired
	OrderRepo orderRepo;
	
	private final String REST_DIR = "/rest/";
	private final String GET_ITEM = REST_DIR + "getItem";
	private final String GET_ALL_ITEMS = REST_DIR + "getAllItems";
	private final String GET_FLOWER_INVENTORY = REST_DIR + "getFlowerInventory";
	private final String GET_ALL_ORDERS = REST_DIR + "getAllOrders";
	
	@RequestMapping(GET_ITEM)
	public Item getFlower(Long id) {
		Item item = itemRepo.findOne(id.intValue());
		return item;
	}
	

	@RequestMapping(GET_ALL_ITEMS)
	public List<Item> getAllFlowers() {
		List<Item> items = itemRepo.findAll();
		return items;
	}
	
	@RequestMapping(GET_FLOWER_INVENTORY + "/{id}")
	public FlowerInventory getFlowerInventory(@PathVariable("id") Long id) {
		FlowerInventory flowerInventory = flowerInventoryRepo.findOne(id.intValue());
		return flowerInventory;
	}
	
	@RequestMapping(GET_ALL_ORDERS)
	public List<Order> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders;
	}
	

}
