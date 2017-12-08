package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Flower;
import com.example.repositories.FlowerRepo;

@RestController
public class RestApiController {
	
	@Autowired
	FlowerRepo flowerRepo;
	
	private final String REST_DIR = "/rest/";
	private final String GET_FLOWER = REST_DIR + "getFlower";
	private final String GET_ALL_FLOWERS = REST_DIR + "getAllFlowers";
	
	@RequestMapping(GET_FLOWER)
	public Flower getFlower(Long id) {
		Flower flower = flowerRepo.findOne(id.intValue());
		return flower;
	}
	
	@RequestMapping(GET_ALL_FLOWERS)
	public List<Flower> getAllFlowers() {
		List<Flower> flowers = flowerRepo.findAll();
		return flowers;
	}
	

}
