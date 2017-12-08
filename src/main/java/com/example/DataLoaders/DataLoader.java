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
import com.example.repositories.FlowerInventoryRepo;
import com.example.repositories.FlowerRepo;
import com.example.repositories.PersonRepo;
import com.example.rest.entities.FlowerInventory;

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
	@Autowired
	FlowerInventoryRepo flowerInventoryRepo;
	
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{
		Person minnieMouse = new Person("Minnie Mouse", 65, "minnie@cit.ie");
		Person daisyDuck = new Person("Daisy Duck", 50, "daisy@cit.ie");
		Person gru = new Person("Gru", 56, "gru@cit.ie");
		
		Card card = new Card("Douglas", "Mary", minnieMouse, "Hi", "Bye");
		Card card2 = new Card("CIT", "Conor", daisyDuck, "Hi", "Bye");
		Card card3 = new Card("Mahon", "Louise", gru, "Hi", "Bye");
		
		Flower daffodil = new Flower(25, "Daffodil", 1.50, Category.FLOWER, "Yellow");
		Flower rose = new Flower(50, "Rose", 15.00, Category.FLOWER, "Red");
		Flower daisy = new Flower(75, "Daisy", 3.50, Category.FLOWER, "White and Yellow");
		
		ArrayList<Flower> bouquetDaffodils = new ArrayList<Flower>();
		ArrayList<Flower> bouquetRoses = new ArrayList<Flower>();
		ArrayList<Flower> bouquetDaisies = new ArrayList<Flower>();

		for (int index = 0; index < 20; index++) {
			bouquetDaffodils.add(daffodil);
			bouquetRoses.add(rose);
			bouquetDaisies.add(daisy);
		}
		
		ArrayList<Item> packageItems = new ArrayList<Item>();
		ArrayList<Item> packageItems2 = new ArrayList<Item>();
		ArrayList<Item> packageItems3 = new ArrayList<Item>();
		
		packageItems.add(daffodil);
		packageItems2.add(rose);
		packageItems3.add(daisy);

		Bouquet bouquet = new Bouquet(bouquetDaffodils);
		Bouquet bouquet2 = new Bouquet(bouquetRoses);
		Bouquet bouquet3 = new Bouquet(bouquetDaisies);

		
		EventPackage eventPackage = new EventPackage(packageItems, bouquet);
		EventPackage eventPackage2 = new EventPackage(packageItems2, bouquet2);
		EventPackage eventPackage3 = new EventPackage(packageItems3, bouquet3);
		
		FlowerInventory flowerInventory = new FlowerInventory();
		flowerInventory.addFlower(daffodil);
		flowerInventory.addFlower(rose);
		flowerInventory.addFlower(daisy);

		personRepo.save(minnieMouse);
		personRepo.save(daisyDuck);
		personRepo.save(gru);
		flowerRepo.save(daffodil);
		flowerRepo.save(rose);
		flowerRepo.save(daisy);
		eventPackageRepo.save(eventPackage);
		eventPackageRepo.save(eventPackage2);
		eventPackageRepo.save(eventPackage3);
		flowerInventoryRepo.save(flowerInventory);

	}
}
