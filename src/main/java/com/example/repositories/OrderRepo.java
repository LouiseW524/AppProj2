package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.rest.entities.Order;

public interface OrderRepo extends MongoRepository<Order, Integer> {

}
