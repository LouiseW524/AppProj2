package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.EventPackageOrder;
import com.example.entities.Order;
import com.example.repositories.EventPackageOrderRepo;

@RestController
@RequestMapping("/rest/eventPackages/orders")
public class RestEventPackageOrderController {
	@Autowired
	EventPackageOrderRepo eventPackageOrderRepo;
	
	private final String ID_SUFFIX = "/{id}";
	private final String ID = "id";
	private final String BALANCE = "/balance"; 

	@RequestMapping(method = RequestMethod.GET, value = ID_SUFFIX)
	public EventPackageOrder getOrder(@PathVariable(ID) Long id) {
		EventPackageOrder eventPackageOrder = eventPackageOrderRepo.findOne(id.intValue());
		return eventPackageOrder;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<EventPackageOrder> getAllOrders() {
		List<EventPackageOrder> eventPackageOrders = eventPackageOrderRepo.findAll();
		return eventPackageOrders;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addOrder(@RequestBody EventPackageOrder order) {
		eventPackageOrderRepo.save(order);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = BALANCE)
	public List<Double> getAllOrdersBalance() {
		List<EventPackageOrder> orders = eventPackageOrderRepo.findAll();
		List<Double> balances = new ArrayList<Double>();
		for (EventPackageOrder order : orders) {
			balances.add(order.getBalance());
		}
		return balances;
	}

}
