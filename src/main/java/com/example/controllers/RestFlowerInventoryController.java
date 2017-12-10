package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.FlowerInventory;
import com.example.repositories.FlowerInventoryRepo;

@RestController
@RequestMapping("/rest/flowerInventory")
public class RestFlowerInventoryController {
	
	@Autowired
	FlowerInventoryRepo flowerInventoryRepo;
	
	private final String ID_SUFFIX = "/{id}";
	private final String ID = "id";
	
	@RequestMapping(method = RequestMethod.GET, value = ID_SUFFIX)
	public FlowerInventory getFlowerInventory(@PathVariable(ID) Long id) {
		FlowerInventory flowerInventory = flowerInventoryRepo.findOne(id.intValue());
		return flowerInventory;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FlowerInventory> getFlowerInventories() {
		List<FlowerInventory> flowerInventories = flowerInventoryRepo.findAll();
		return flowerInventories;
	}

}
