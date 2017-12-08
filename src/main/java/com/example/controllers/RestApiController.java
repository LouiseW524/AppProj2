package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Flower;
import com.example.entities.Item;
import com.example.enums.Category;
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
	private final String ID_SUFFIX = "/{id}";

	private final String ID = "id";
	private final String ITEMS = "items";
	private final String ORDERS = "orders";
	private final String FLOWERS = "flowers";
	private final String FLOWER_INVENTORY = "flowerInventory";
	private final String BALANCE = "balance";

	private final String GET_ITEM = REST_DIR + ITEMS + ID_SUFFIX;
	private final String GET_ALL_ITEMS = REST_DIR + ITEMS;
	private final String GET_FLOWER = REST_DIR + FLOWERS + ID_SUFFIX;
	private final String GET_ALL_FLOWERS = REST_DIR + FLOWERS;
	private final String GET_FLOWER_INVENTORY = REST_DIR + FLOWER_INVENTORY + ID_SUFFIX;
	private final String GET_ALL_FLOWER_INVENTORIES = REST_DIR + FLOWER_INVENTORY;
	private final String GET_ORDER = REST_DIR + ORDERS + ID_SUFFIX;
	private final String GET_ALL_ORDERS = REST_DIR + ORDERS;
	private final String GET_ALL_ORDER_BALANCE = REST_DIR + ORDERS + "/" + BALANCE; 

	@RequestMapping(GET_ITEM)
	public Item getItem(@PathVariable(ID) Long id) {
		Item item = itemRepo.findOne(id.intValue());
		return item;
	}

	@RequestMapping(GET_ALL_ITEMS)
	public List<Item> getAllItems() {
		List<Item> items = itemRepo.findAll();
		return items;
	}

	@RequestMapping(GET_FLOWER)
	public Flower getFlower(@PathVariable(ID) Long id) {
		Item item = itemRepo.findOne(id.intValue());
		if (item.getCategory() == Category.FLOWER) {
			Flower flower = (Flower) item;
			return flower;
		} else {
			return null;
		}
	}

	@RequestMapping(GET_ALL_FLOWERS)
	public List<Item> getAllFlowers() {
		List<Item> items = itemRepo.findAll();
		List<Item> flowers = new ArrayList<Item>();
		for (Item item : items) {
			if (item.getCategory() == Category.FLOWER) {
				flowers.add(item);
			}
		}
		return flowers;
	}

	@RequestMapping(GET_FLOWER_INVENTORY)
	public FlowerInventory getFlowerInventory(@PathVariable(ID) Long id) {
		FlowerInventory flowerInventory = flowerInventoryRepo.findOne(id.intValue());
		return flowerInventory;
	}
	
	@RequestMapping(GET_ALL_FLOWER_INVENTORIES)
	public List<FlowerInventory> getFlowerInventories() {
		List<FlowerInventory> flowerInventories = flowerInventoryRepo.findAll();
		return flowerInventories;
	}

	@RequestMapping(GET_ORDER)
	public Order getOrder(@PathVariable(ID) Long id) {
		Order order = orderRepo.findOne(id.intValue());
		return order;
	}

	@RequestMapping(GET_ALL_ORDERS)
	public List<Order> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders;
	}
	
	@RequestMapping(GET_ALL_ORDER_BALANCE)
	public List<Double> getAllOrdersBalance() {
		List<Order> orders = orderRepo.findAll();
		List<Double> balances = new ArrayList<Double>();
		for (Order order : orders) {
			balances.add(order.getBalance());
		}
		return balances;
	}

}
