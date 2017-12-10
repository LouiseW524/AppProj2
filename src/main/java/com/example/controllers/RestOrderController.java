package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Order;
import com.example.repositories.OrderRepo;

@RestController
@RequestMapping("/rest/orders")
public class RestOrderController {
	
	@Autowired
	OrderRepo orderRepo;
	
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
	
	@RequestMapping(method = RequestMethod.GET, value = BALANCE)
	public List<Double> getAllOrdersBalance() {
		List<Order> orders = orderRepo.findAll();
		List<Double> balances = new ArrayList<Double>();
		for (Order order : orders) {
			balances.add(order.getBalance());
		}
		return balances;
	}

}
