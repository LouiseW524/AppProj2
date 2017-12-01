package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entities.Item;

public interface ItemRepo extends MongoRepository<Item, Integer>{

}
