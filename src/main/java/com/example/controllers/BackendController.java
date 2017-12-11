package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entities.FlowerInventory;
import com.example.entities.Order;

@Controller
public class BackendController {
	
	private final String ID_SUFFIX = "/{id}";
	private final String ID = "id";
	
	private final String REST_URL = "http://localhost:8080/rest";
	private final String ORDERS = "/orders";
	private final String FLOWER_INVENTORY = "/flowerInventory";
	private final String BACKEND = "/backend";
	
	private final String SPECIFY_REST_ORDER = REST_URL + ORDERS + ID_SUFFIX;
	private final String REST_ORDERS = REST_URL + ORDERS;
	private final String REST_FLOWER_INVENTORY = REST_URL + FLOWER_INVENTORY;
	
	
	private final String VIEW_ORDER = BACKEND + "/viewOrder";
	private final String ALL_ORDERS = BACKEND + "/allOrders";
	private final String DASHBOARD = BACKEND + "/dashboard";
	
	@GetMapping(VIEW_ORDER + ID_SUFFIX)
	public String getOrder(Model model, @PathVariable(ID) Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Order order = restTemplate.getForObject(SPECIFY_REST_ORDER, Order.class, id.intValue());
		model.addAttribute("order", order);
		return VIEW_ORDER;		
	}
	
	@GetMapping(ALL_ORDERS)
	public String getOrders(Model model) {
		Order[] orders = getOrders();
		model.addAttribute("orders", orders);
		return ALL_ORDERS;		
	}
	
	@GetMapping(DASHBOARD)
	public String showDashboard(Model model) {
		FlowerInventory flowerInventory = getFlowerInventory();
		Order[] orders = getOrders();
		double balance = getOutstandingBalance(orders);
		int orderCount = orders.length;
		double totalOrderValue = getOrdersValue(orders);
		
		model.addAttribute("flowerInventory", flowerInventory);
		model.addAttribute("balance", balance);
		model.addAttribute("orderCount", orderCount);
		model.addAttribute("ordersValue", totalOrderValue);
		return DASHBOARD;
	}
	
	
	public FlowerInventory getFlowerInventory() {
		RestTemplate restTemplate = new RestTemplate();
		FlowerInventory[] flowerInventory = restTemplate.getForObject(REST_FLOWER_INVENTORY, FlowerInventory[].class);
		return flowerInventory[0];
	}
	
	public double getOrdersValue(Order[] orders) {
		double totalValue = 0.0;
		for (Order order : orders) {
			totalValue += order.getOrderPrice();
		}
		return totalValue;
	}
	
	public double getOutstandingBalance(Order[] orders) {
		double balance = 0.0;
		for (Order order : orders) {
			balance += order.getBalance();
		}
		
		return balance;
	}
	
	public Order[] getOrders() {
		RestTemplate restTemplate = new RestTemplate();
		Order[] orders = restTemplate.getForObject(REST_ORDERS, Order[].class);
		return orders;
	}

}
