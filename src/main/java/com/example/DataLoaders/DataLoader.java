package com.example.DataLoaders;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.entities.Bouquet;
import com.example.entities.Card;
import com.example.entities.EventPackage;
import com.example.entities.Flower;
import com.example.entities.Item;
import com.example.entities.Person;
import com.example.enums.Category;
import com.example.repositories.EventPackageRepo;
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
	@Autowired
	EventPackageRepo eventPackageRepo;
	
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{
		Person person = new Person(1,"Minnie Mouse", 65, "minnie@cit.ie");
		Person person2 = new Person(2,"Daisy Duck", 50, "daisy@cit.ie");
		Person person3 = new Person(3,"Gru", 56, "gru@cit.ie");
		
		Card card = new Card("Douglas", "Mary", person, "Hi", "Bye");
		Card card2 = new Card("CIT", "Conor", person2, "Hi", "Bye");
		Card card3 = new Card("Mahon", "Louise", person3, "Hi", "Bye");
		
		Flower flower = new Flower(1, "Daffodil", 1.50, Category.FLOWER, "Yellow");
		Flower flower2 = new Flower(2, "Rose", 15.00, Category.FLOWER, "Red");
		Flower flower3 = new Flower(3, "Daisy", 3.50, Category.FLOWER, "White and Yellow");
		
		ArrayList<Flower> bouquetFlowers = new ArrayList<Flower>();
		ArrayList<Flower> bouquetFlowers2 = new ArrayList<Flower>();
		ArrayList<Flower> bouquetFlowers3 = new ArrayList<Flower>();

		bouquetFlowers.add(flower);
		bouquetFlowers2.add(flower2);
		bouquetFlowers3.add(flower3);
		
		ArrayList<Item> packageItems = new ArrayList<Item>();
		ArrayList<Item> packageItems2 = new ArrayList<Item>();
		ArrayList<Item> packageItems3 = new ArrayList<Item>();
		
		packageItems.add(flower);
		packageItems2.add(flower2);
		packageItems3.add(flower3);

		Bouquet bouquet = new Bouquet(bouquetFlowers, card);
		Bouquet bouquet2 = new Bouquet(bouquetFlowers2, card2);
		Bouquet bouquet3 = new Bouquet(bouquetFlowers3, card3);

		
		EventPackage eventPackage = new EventPackage( 1, packageItems, bouquet);
		EventPackage eventPackage2 = new EventPackage( 2, packageItems2, bouquet2);
		EventPackage eventPackage3 = new EventPackage( 3, packageItems3, bouquet3);

		personRepo.save(person);
		personRepo.save(person2);
		personRepo.save(person3);
		flowerRepo.save(flower);
		flowerRepo.save(flower2);
		flowerRepo.save(flower3);
		eventPackageRepo.save(eventPackage);
		eventPackageRepo.save(eventPackage2);
		eventPackageRepo.save(eventPackage3);

	}
}
