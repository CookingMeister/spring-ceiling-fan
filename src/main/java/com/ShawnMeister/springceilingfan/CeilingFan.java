package com.shawnmeister.springceilingfan;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CeilingFan {

    private static final Logger logger = LoggerFactory.getLogger(CeilingFan.class);

    private int speed;
    private boolean reversed;

    // Initialize the ceiling fan to 0 speed and not reversed
    public CeilingFan() {
        this.speed = 0;
        this.reversed = false;
    }

    // Set the speed of the ceiling fan
    public void pullSpeedCord() {
        try {
            // Fan is disabled on December 25th
            if (!isDecember25th()) {
                speed = (speed + 1) % 4;
                logger.info("Speed: {}, Direction: {}", speed, reversed ? "Reversed" : "Forward");
            } else {
                logger.info("Ceiling fan is disabled on December 25th");
            }
        } catch (Exception e) {
            logger.error("An error occurred while pulling the speed cord: {}", e.getMessage());
        }
    }

    // Set the direction of the ceiling fan
    public void pullDirectionCord() {
        try {
            // Fan is disabled on December 25th
            if (!isDecember25th()) {
                reversed = !reversed;
                logger.info("Speed: {}, Direction: {}", speed, reversed ? "Reversed" : "Forward");
            } else {
                logger.info("Ceiling fan is disabled on December 25th");
            }
        } catch (Exception e) {
            logger.error("An error occurred while pulling the direction cord: {}", e.getMessage());
        }
    }

    // Easter egg
    public void getRecipe() {
        try {
            logger.info("Recipe incoming...");
        } catch (Exception e) {
            logger.error("An error occurred while getting the recipe: {}", e.getMessage());
        }
    }

    // Check if it is December 25th
    public boolean isDecember25th() {
        try {
            LocalDate today = getToday();
            logger.info("Today is: {}", today);
            return today.getMonthValue() == 12 && today.getDayOfMonth() == 25;
        } catch (Exception e) {
            logger.error("An error occurred while checking the date: {}", e.getMessage());
            return false;
        }
    }

    // Method to get today's date (can be mocked in tests)
    protected LocalDate getToday() {
        return LocalDate.now();
    }

    // Getters and setters
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }

    public int getSpeed() {
        logger.info("getSpeed: {}", this.speed);
        return speed;
    }

    public boolean isReversed() {
        logger.info("isReversed: {}", this.reversed);
        return reversed;
    }
}
