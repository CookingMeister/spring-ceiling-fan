package com.ShawnMeister.springceilingfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCeilingFanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCeilingFanApplication.class, args);
		System.out.println("Hello, I am a big fan");
		CeilingFan ceilingFan = new CeilingFan();
		KeyEventHandler keyEventHandler = new KeyEventHandler(ceilingFan);
		keyEventHandler.createKeyListener();
	}

}