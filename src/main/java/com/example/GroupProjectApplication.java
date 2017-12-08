package com.example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//had MongoSocketOpenException, used this to overcome issue
public class GroupProjectApplication {

	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("cmd /c start \"\" start_mongo.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(GroupProjectApplication.class, args);
	}
}
