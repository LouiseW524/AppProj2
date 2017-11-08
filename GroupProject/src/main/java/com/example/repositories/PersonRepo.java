package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entities.Person;

public interface PersonRepo  extends MongoRepository<Person, Integer>{

}
