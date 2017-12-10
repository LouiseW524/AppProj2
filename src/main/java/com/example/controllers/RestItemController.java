package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entities.Item;
import com.example.repositories.ItemRepo;

@RestController
@RequestMapping("rest/items")
public class RestItemController {
	
	@Autowired
	ItemRepo itemRepo;
	
	private final String ID_SUFFIX = "/{id}";
	private final String ID = "id";
	
	@RequestMapping(method = RequestMethod.GET, value = ID_SUFFIX)
	public Item getItem(@PathVariable(ID) Long id) {
		Item item = itemRepo.findOne(id.intValue());
		return item;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = ID_SUFFIX)
	public void deleteItem(@PathVariable(ID) Long id) {
		itemRepo.delete(id.intValue());		
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public void addItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
		itemRepo.save(item);	
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = ID_SUFFIX) 
	public void updateItem(@PathVariable(ID) Long id, @RequestBody Item item) {
		Item updater = itemRepo.findOne(id.intValue());
		updater.setCategory(item.getCategory());
		updater.setName(item.getName());
		updater.setPrice(item.getPrice());
		itemRepo.save(updater);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Item> getAllItems() {
		List<Item> items = itemRepo.findAll();
		return items;
	}
	
	@RequestMapping(method = RequestMethod.DELETE) 
	public void deleteAllItems() {
		itemRepo.deleteAll();
	}


}
