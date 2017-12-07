package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Flower;
import com.example.repositories.FlowerRepo;

@RestController
public class RestApiController {
	
	@Autowired
	FlowerRepo flowerRepo;
	
	private final String REST_DIR = "/rest/";
	private final String GET_FLOWER = REST_DIR + "getFlower";
	
	@RequestMapping(GET_FLOWER)
//	@RequestParam(value="id" defaultValue="1") 
	public Flower getFlower(int id) {
		Flower flower = flowerRepo.findOne(id);
		return flower;
	}

}
