package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entities.EventPackageOrder;

public interface EventPackageOrderRepo extends MongoRepository<EventPackageOrder, Integer> {

}
