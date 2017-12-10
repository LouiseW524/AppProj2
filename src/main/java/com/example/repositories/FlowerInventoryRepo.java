package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entities.FlowerInventory;

public interface FlowerInventoryRepo extends MongoRepository<FlowerInventory, Integer> {

}
