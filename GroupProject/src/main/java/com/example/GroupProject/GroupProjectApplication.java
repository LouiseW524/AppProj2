package com.example.GroupProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//had MongoSocketOpenException, used this to overcome issue
public class GroupProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);
	}
}
