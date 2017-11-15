package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entities.Flower;

public interface FlowerRepo extends MongoRepository<Flower, Integer>{

}
