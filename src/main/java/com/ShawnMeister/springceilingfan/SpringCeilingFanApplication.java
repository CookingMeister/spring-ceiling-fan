package com.ShawnMeister.springceilingfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import com.ShawnMeister.springceilingfan.CeilingFan;

@SpringBootApplication
public class SpringCeilingFanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCeilingFanApplication.class, args);
		System.out.println("Hello, I am a big fan");
		CeilingFan fan = new CeilingFan();
		fan.pullSpeedCord();
	}

}
