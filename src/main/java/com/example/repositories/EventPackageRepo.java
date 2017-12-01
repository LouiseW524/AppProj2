package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entities.EventPackage;

public interface EventPackageRepo extends MongoRepository<EventPackage, Integer>{

}
