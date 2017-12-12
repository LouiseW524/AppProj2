package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.EventPackage;
import com.example.repositories.EventPackageRepo;


@RestController
@RequestMapping("/rest/eventPackages")
public class RestEventPackageController {
	
	@Autowired
	EventPackageRepo eventPackageRepo;
	
	private final String ID_SUFFIX = "/{id}";
	private final String ID = "id"; 

	@RequestMapping(method = RequestMethod.GET, value = ID_SUFFIX)
	public EventPackage getEventPackage(@PathVariable(ID) Long id) {
		EventPackage eventPackage = eventPackageRepo.findOne(id.intValue());
		return eventPackage;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<EventPackage> getAllEventPackages() {
		List<EventPackage> eventPackage = eventPackageRepo.findAll();
		return eventPackage;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addEventPackage(@RequestBody EventPackage eventPackage) {
		eventPackageRepo.save(eventPackage);
	}
}
