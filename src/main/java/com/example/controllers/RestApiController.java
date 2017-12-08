package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Flower;
import com.example.entities.Item;
import com.example.repositories.ItemRepo;

@RestController
public class RestApiController {
	
	@Autowired
	ItemRepo flowerRepo;
	
	private final String REST_DIR = "/rest/";
	private final String GET_FLOWER = REST_DIR + "getFlower";
	
	@RequestMapping(GET_FLOWER)
//	@RequestParam(value="id" defaultValue="1") 
	public Item getFlower(int id) {
		Item flower = flowerRepo.findOne(id);
		return flower;
	}

}
