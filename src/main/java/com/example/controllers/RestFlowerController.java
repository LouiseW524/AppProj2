package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Flower;
import com.example.entities.Item;
import com.example.enums.Category;
import com.example.repositories.ItemRepo;

@RestController
@RequestMapping("/rest/flowers")
public class RestFlowerController {
	
	@Autowired
	ItemRepo itemRepo;

	private final String ID_SUFFIX = "/{id}";
	private final String ID = "id";
	
	
	@RequestMapping(method = RequestMethod.GET, value = ID_SUFFIX)
	public Flower getFlower(@PathVariable(ID) Long id) {
		Item item = itemRepo.findOne(id.intValue());
		if (item.getCategory() == Category.FLOWER) {
			Flower flower = (Flower) item;
			return flower;
		} else {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
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


}
