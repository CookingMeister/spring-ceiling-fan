package com.shawnmeister.springceilingfan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringCeilingFanApplication implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SpringCeilingFanApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringCeilingFanApplication.class, args);
            logger.info("Hello, I am a big fan!");
        } catch (Exception e) {
            logger.error("Error occurred", e);
        }
    }
}
