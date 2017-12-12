package com.example.DataLoaders;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.entities.Bouquet;
import com.example.entities.Card;
import com.example.entities.EventPackage;
import com.example.entities.EventPackageOrder;
import com.example.entities.Flower;
import com.example.entities.FlowerInventory;
import com.example.entities.Item;
import com.example.entities.Order;
import com.example.entities.Person;
import com.example.enums.Category;
import com.example.repositories.EventPackageOrderRepo;
import com.example.repositories.EventPackageRepo;
import com.example.repositories.FlowerInventoryRepo;
import com.example.repositories.ItemRepo;
import com.example.repositories.OrderRepo;
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
	EventPackageRepo eventPackageRepo;
	@Autowired
	FlowerInventoryRepo flowerInventoryRepo;
	@Autowired
	ItemRepo itemRepo;
	@Autowired
	OrderRepo orderRepo;
	@Autowired
	EventPackageOrderRepo eventPackageOrderRepo;
	
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{
		Person minnieMouse = new Person("Minnie Mouse", 65, "minnie@cit.ie");
		Person daisyDuck = new Person("Daisy Duck", 50, "daisy@cit.ie");
		Person gru = new Person("Gru", 56, "gru@cit.ie");		
		personRepo.save(minnieMouse);
		personRepo.save(daisyDuck);
		personRepo.save(gru);
		
		Card cardForMary = new Card("Douglas", "Mary", minnieMouse, "Hi", "Bye", "Card", 5.75, Category.CARD);
		Card cardForConor = new Card("CIT", "Conor", daisyDuck, "Hi", "Bye", "Card", 5.75, Category.CARD);
		Card cardForLouise = new Card("Mahon", "Louise", gru, "Hi", "Bye", "Card", 5.75, Category.CARD);		
		itemRepo.save(cardForMary);
		itemRepo.save(cardForConor);
		itemRepo.save(cardForLouise);
		
		Flower daffodil = new Flower(25, "Daffodil", 1.50, Category.FLOWER, "Yellow");
		Flower rose = new Flower(50, "Rose", 15.00, Category.FLOWER, "Red");
		Flower daisy = new Flower(75, "Daisy", 3.50, Category.FLOWER, "White and Yellow");		
		itemRepo.save(daffodil);
		itemRepo.save(rose);
		itemRepo.save(daisy);
		
		ArrayList<Flower> listDaffodils = new ArrayList<Flower>();
		ArrayList<Flower> listRoses = new ArrayList<Flower>();
		ArrayList<Flower> listDaisies = new ArrayList<Flower>();

		for (int index = 0; index < 20; index++) {
			listDaffodils.add(daffodil);
			listRoses.add(rose);
			listDaisies.add(daisy);
		}
		
		ArrayList<Item> maryPackage = new ArrayList<Item>();
		ArrayList<Item> conorPackage = new ArrayList<Item>();
		ArrayList<Item> louisePackage = new ArrayList<Item>();
		
		maryPackage.add(cardForMary);
		conorPackage.add(cardForConor);
		louisePackage.add(cardForLouise);

		Bouquet bouquetDaffodils = new Bouquet(listDaffodils);
		Bouquet bouquetRoses = new Bouquet(listRoses);
		Bouquet bouquetDaisies = new Bouquet(listDaisies);

		
		EventPackage eventPackageForMary = new EventPackage("Birthday",maryPackage, bouquetDaffodils);
		EventPackage eventPackageForConor = new EventPackage("Anniversary",conorPackage, bouquetRoses);
		EventPackage eventPackageForLouise = new EventPackage("Valentines",louisePackage, bouquetDaisies);
		eventPackageRepo.save(eventPackageForMary);
		eventPackageRepo.save(eventPackageForConor);
		eventPackageRepo.save(eventPackageForLouise);
		
		EventPackageOrder maryOrder = new EventPackageOrder(eventPackageForMary, "Mary");
		EventPackageOrder conorOrder = new EventPackageOrder(eventPackageForConor, "Conor");
		EventPackageOrder louiseOrder = new EventPackageOrder(eventPackageForLouise, "Louise");
		
		eventPackageOrderRepo.save(maryOrder);
		eventPackageOrderRepo.save(conorOrder);
		eventPackageOrderRepo.save(louiseOrder);
		
		String phillie = "Phillie";
		
		Order daffodilOrder = new Order(listDaffodils, phillie);
		daffodilOrder.pay(daffodilOrder.getBalance() - 75.50);
		Order rosesOrder = new Order(listRoses, phillie);
		rosesOrder.pay(2150.00);
		Order daisiesOrder = new Order(listDaisies, phillie);
		daisiesOrder.pay(150.00);		
		orderRepo.save(daffodilOrder);
		orderRepo.save(rosesOrder);
		orderRepo.save(daisiesOrder);
		
		FlowerInventory flowerInventory = new FlowerInventory();		
		daffodil.setQuantity(4000);
		flowerInventory.addFlower(daffodil);		
		rose.setQuantity(1500);
		flowerInventory.addFlower(rose);		
		daisy.setQuantity(3500);
		flowerInventory.addFlower(daisy);		
		flowerInventoryRepo.save(flowerInventory);

	}
}
