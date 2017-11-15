package com.example.DataLoaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.entities.Flower;
import com.example.entities.Person;
import com.example.repositories.FlowerRepo;
import com.example.repositories.PersonRepo;

//ApplicationRunner is run before after the beans have been created and the application
//context has been completed.
//@Component makes it a bean so it is "seen" by Spring
@Component // ensures this is run because it is a bean
public class DataLoader implements ApplicationRunner
{
	@Autowired // Find a PersonRepo bean and autowire it into personRepo
	PersonRepo personRepo;
	@Autowired
	FlowerRepo flowerRepo;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{
		personRepo.save(new Person(1,"Minnie Mouse", 65, "minnie@cit.ie"));
		personRepo.save(new Person(2,"Daisy Duck", 50, "daisy@cit.ie"));
		personRepo.save(new Person(3,"Gru", 56, "gru@cit.ie"));
		flowerRepo.save(new Flower(1, "Daffodil", 1.50, "Yellow"));
		flowerRepo.save(new Flower(2, "Rose", 15.00, "Red"));
		flowerRepo.save(new Flower(3, "Daisy", 3.50, "White and Yellow"));
	}
}
